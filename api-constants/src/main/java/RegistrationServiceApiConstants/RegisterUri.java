package RegistrationServiceApiConstants;

/**
 * Author : Rohit Parihar
 * Date : 12/29/2022
 * Time : 11:02 PM
 * Class : UriConstants
 * Project : Bloggios-Backend
 */

public class RegisterUri {
    public static final String REGISTER_CONTROLLER_ENTRY_POINT = "/api/registration";
    public static final String VALIDATE_USER = "/verifyUserRegistration";
    public static final String CHECK_BY_USER_ID = "/auth/check-id/{userId}";
    public static final String GET_NAME = "/auth/name/{userId}";
    public static final String REGISTER_SERVICE = "lb://registration-service/api/registration/";
}
