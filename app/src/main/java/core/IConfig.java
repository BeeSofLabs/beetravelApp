package core;

/**
 * Created by ary on 4/6/17.
 */

public interface IConfig {
    String USER_PASSWORD_KEY = "password";

    // API Host
    String API_HOST_NAME = "http://api.tvp.com";

    // API Path
    String API_GET_AUTHORIZATION_CODE_PATH = "";
    String API_GET_ACCESS_TOKEN_PATH = "";

    // API payload structure
    String API_DATA_PAYLOAD = "seeds";
    String API_MESSAGE_PAYLOAD = "message";
    String API_META_PAYLOAD = "meta";

}
