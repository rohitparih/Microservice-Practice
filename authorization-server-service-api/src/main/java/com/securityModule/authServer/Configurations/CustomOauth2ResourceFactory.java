package com.securityModule.authServer.Configurations;

import com.securityModule.authServer.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Map;

/**
 * Author : Rohit Parihar
 * Date : 12/26/2022
 * Time : 1:05 AM
 * Class : CustomOauth2ResourceFactory
 * Project : Bloggios-Backend
 */

public class CustomOauth2ResourceFactory extends DefaultOAuth2RequestFactory {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    public CustomOauth2ResourceFactory(ClientDetailsService clientDetailsService) {
        super(clientDetailsService);
    }

    @Override
    public TokenRequest createTokenRequest(Map<String, String> requestParameters,
                                           ClientDetails authenticatedClient) {
        if (requestParameters.get("grant_type").equals("refresh_token")) {
            OAuth2Authentication authentication = tokenStore.readAuthenticationForRefreshToken(
                    tokenStore.readRefreshToken(requestParameters.get("refresh_token")));
            SecurityContextHolder.getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(authentication.getName(), null,
                            userDetailsService.loadUserByUsername(authentication.getName()).getAuthorities()));
        }
        return super.createTokenRequest(requestParameters, authenticatedClient);
    }
}
