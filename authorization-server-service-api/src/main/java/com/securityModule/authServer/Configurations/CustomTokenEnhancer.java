package com.securityModule.authServer.Configurations;

import com.securityModule.authServer.Entity.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author : Rohit Parihar
 * Date : 12/26/2022
 * Time : 11:55 PM
 * Class : CustomTokenEnhancer
 * Project : Bloggios-Backend
 */

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("userId", user.getUserId());
        ((DefaultOAuth2AccessToken) accessToken)
                .setAdditionalInformation(additionalInfo);
        accessToken = super.enhance(accessToken, authentication);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(new HashMap<>());
        return accessToken;
    }

    /*
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
        info.put("email", user.getEmail());
        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);

        return super.enhance(customAccessToken, authentication);
    }
     */
}
