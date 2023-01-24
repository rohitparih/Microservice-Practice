package com.userModule.registrationService.Config;

import com.userModule.registrationService.Entity.CustomPrincipal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author : Rohit Parihar
 * Date : 12/27/2022
 * Time : 2:30 AM
 * Class : com.userModule.registrationService.Config.CustomUserAuthenticationConverter
 * Project : Bloggios-Backend
 */

public class CustomUserAuthenticationConverter implements UserAuthenticationConverter  {


    private final String USERID = "userId";

    private Collection<? extends GrantedAuthority> defaultAuthorities;

    public void setDefaultAuthorities(String[] defaultAuthorities) {
        this.defaultAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(StringUtils.arrayToCommaDelimitedString(defaultAuthorities));
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put(UserAuthenticationConverter.USERNAME, userAuthentication.getName());
        if (userAuthentication.getAuthorities() != null && !userAuthentication.getAuthorities().isEmpty())
            response.put(UserAuthenticationConverter.AUTHORITIES, AuthorityUtils.authorityListToSet(userAuthentication.getAuthorities()));
        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(UserAuthenticationConverter.USERNAME))
            return new UsernamePasswordAuthenticationToken(
                    new CustomPrincipal(map.get(UserAuthenticationConverter.USERNAME).toString(), map.get(USERID).toString()), "N/A",
                    getAuthorities(map));
        return null;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
        if (!map.containsKey(UserAuthenticationConverter.AUTHORITIES))
            return defaultAuthorities;

        Object authorities = map.get(UserAuthenticationConverter.AUTHORITIES);

        if (authorities instanceof String)
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);

        if (authorities instanceof Collection)
            return AuthorityUtils.commaSeparatedStringToAuthorityList(
                    StringUtils.collectionToCommaDelimitedString((Collection<?>) authorities));

        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }
}
