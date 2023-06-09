package EL.IBDA.OAuth;

import EL.IBDA.domain.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {

    OAuthProvider oAuthProvider();

    MultiValueMap<String, String> makeBody();
}