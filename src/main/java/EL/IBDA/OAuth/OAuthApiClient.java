package EL.IBDA.OAuth;

import EL.IBDA.domain.OAuthProvider;

public interface OAuthApiClient {

    OAuthProvider oAuthProvider();

    String requestAccessToken(OAuthLoginParams params);

    OAuthInfoResponse requestOauthInfo(String accessToken);
}

