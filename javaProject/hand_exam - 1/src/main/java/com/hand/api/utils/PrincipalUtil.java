package com.hand.api.utils;

import io.choerodon.core.oauth.CustomUserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.security.Principal;

public class PrincipalUtil {

    private final CustomUserDetails details;

    public PrincipalUtil(Principal principal) {
        this.details = (CustomUserDetails) ((OAuth2AuthenticationDetails) ((OAuth2Authentication) principal).getDetails()).getDecodedDetails();
    }

    public CustomUserDetails getDetails() {
        return details;
    }
}