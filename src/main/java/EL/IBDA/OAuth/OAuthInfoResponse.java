package EL.IBDA.OAuth;

import EL.IBDA.domain.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}
