package AuthorizationServerServiceApi;

/**
 * Author : Rohit Parihar
 * Date : 12/29/2022
 * Time : 11:17 PM
 * Class : ConfigurationConstants
 * Project : Bloggios-Backend
 */

public class ConfigurationConstants {
    public static final String CLIENT = "postman";
    public static final String CLIENT_SECRET = "secret";
    public static final String[] RESOURCE_ID = {"USER_CLIENT_RESOURCE", "USER_ADMIN_RESOURCE"};
    public static final String[] GRANT_TYPES = {"password", "authorization_token", "refresh_token", "implicit"};
    public static final String[] SCOPES = {"role_admin", "role_user"};
}
