package com.userModule.registrationService.Config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 * Author : Rohit Parihar
 * Date : 12/27/2022
 * Time : 2:29 AM
 * Class : com.userModule.registrationService.Config.CustomAccessTokenConverter
 * Project : Bloggios-Backend
 */

@Component
public class CustomAccessTokenConverter implements AccessTokenConverter, JwtAccessTokenConverterConfigurer {

    private boolean includeGrantType;

    private UserAuthenticationConverter userTokenConverter = new CustomUserAuthenticationConverter();

    @Override
    public void configure(JwtAccessTokenConverter converter) {
        converter.setAccessTokenConverter(this);
    }

    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(value);
        Map<String, Object> info = new HashMap<String, Object>(map);

        info.remove(AccessTokenConverter.EXP);
        info.remove(AccessTokenConverter.AUD);
        info.remove(AccessTokenConverter.CLIENT_ID);
        info.remove(AccessTokenConverter.SCOPE);

        if (map.containsKey(AccessTokenConverter.EXP))
            token.setExpiration(new Date((Long) map.get(AccessTokenConverter.EXP) * 1000L));

        if (map.containsKey(AccessTokenConverter.JTI))
            info.put(AccessTokenConverter.JTI, map.get(AccessTokenConverter.JTI));

        token.setScope(extractScope(map));
        token.setAdditionalInformation(info);
        return token;
    }

    private Set<String> extractScope(Map<String, ?> map) {
        Set<String> scope = Collections.emptySet();
        if (map.containsKey(AccessTokenConverter.SCOPE)) {
            Object scopeObj = map.get(AccessTokenConverter.SCOPE);
            if (String.class.isInstance(scopeObj))
                scope = new LinkedHashSet<String>(Arrays.asList(String.class.cast(scopeObj).split(" ")));
            else if (Collection.class.isAssignableFrom(scopeObj.getClass())) {
                @SuppressWarnings("unchecked")
                Collection<String> scopeColl = (Collection<String>) scopeObj;
                scope = new LinkedHashSet<String>(scopeColl);
            }
        }
        return scope;
    }


    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        Set<String> scope = extractScope(map);
        Map<String, String> parameters = new HashMap<String, String>();
        Authentication user = userTokenConverter.extractAuthentication(map);

        String clientId = (String) map.get(AccessTokenConverter.CLIENT_ID);
        parameters.put(AccessTokenConverter.CLIENT_ID, clientId);

        if (includeGrantType && map.containsKey(AccessTokenConverter.GRANT_TYPE))
            parameters.put(AccessTokenConverter.GRANT_TYPE, (String) map.get(AccessTokenConverter.GRANT_TYPE));

        Set<String> resourceIds = new LinkedHashSet<String>(
                map.containsKey(AccessTokenConverter.AUD) ? getAudience(map) : Collections.<String>emptySet());

        Collection<? extends GrantedAuthority> authorities = null;

        if (user == null && map.containsKey(AccessTokenConverter.AUTHORITIES)) {
            @SuppressWarnings("unchecked")
            String[] roles = ((Collection<String>) map.get(AccessTokenConverter.AUTHORITIES)).toArray(new String[0]);
            authorities = AuthorityUtils.createAuthorityList(roles);
        }

        OAuth2Request request = new OAuth2Request(parameters, clientId, authorities, true, scope, resourceIds, null,
                null, null);

        return new OAuth2Authentication(request, user);
    }


    private Collection<String> getAudience(Map<String, ?> map) {
        Object auds = map.get(AccessTokenConverter.AUD);

        if (auds instanceof Collection) {
            @SuppressWarnings("unchecked")
            Collection<String> result = (Collection<String>) auds;
            return result;
        }

        return Collections.singleton((String) auds);
    }

    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> response = new HashMap<String, Object>();
        OAuth2Request clientToken = authentication.getOAuth2Request();
        if (!authentication.isClientOnly())
            response.putAll(userTokenConverter.convertUserAuthentication(authentication.getUserAuthentication()));
        else if (clientToken.getAuthorities() != null && !clientToken.getAuthorities().isEmpty())
            response.put(UserAuthenticationConverter.AUTHORITIES,
                    AuthorityUtils.authorityListToSet(clientToken.getAuthorities()));

        if (token.getScope() != null)
            response.put(AccessTokenConverter.SCOPE, token.getScope());

        if (token.getAdditionalInformation().containsKey(AccessTokenConverter.JTI))
            response.put(AccessTokenConverter.JTI, token.getAdditionalInformation().get(AccessTokenConverter.JTI));

        if (token.getExpiration() != null)
            response.put(AccessTokenConverter.EXP, token.getExpiration().getTime() / 1000);

        if (includeGrantType && authentication.getOAuth2Request().getGrantType() != null)
            response.put(AccessTokenConverter.GRANT_TYPE, authentication.getOAuth2Request().getGrantType());
        response.putAll(token.getAdditionalInformation());
        response.put(AccessTokenConverter.CLIENT_ID, clientToken.getClientId());
        if (clientToken.getResourceIds() != null && !clientToken.getResourceIds().isEmpty())
            response.put(AccessTokenConverter.AUD, clientToken.getResourceIds());
        return response;
    }


    public void setUserTokenConverter(UserAuthenticationConverter userTokenConverter) {
        this.userTokenConverter = userTokenConverter;
    }

    public void setIncludeGrantType(boolean includeGrantType) {
        this.includeGrantType = includeGrantType;
    }
}
