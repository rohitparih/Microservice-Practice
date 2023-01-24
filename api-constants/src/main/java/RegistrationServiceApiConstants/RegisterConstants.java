package RegistrationServiceApiConstants;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 12:32 AM
 * Class : Constants
 * Project : register-module
 */

public class RegisterConstants {
    public static final String NAME_VALIDATION = "Name should be greater than 2 Characters and less than 20.";
    public static final String EMAIL_VALIDATION = "Please enter correct Email";
    public static final String USERNAME_VALIDATION = "Username should be greater than 4 characters and less than 20.";
    public static final String PASSWORD_VALIDATION = "Password should be greater than 8 characters";
    public static final String COMPLETE_REGISTRATION_MESSAGE = "Please check your mail and complete registration";
    public static final String REGISTER_SUCCESS_MESSAGE = "User Registered Successfully. Please Register to Continue";
    public static final String USERNAME_TAKEN_MESSAGE = "Username already taken please try with different and unique username";
    public static final String NOT_VALIDATED = "User not validated please try after sometime";
    public static final String EMAIL_TAKEN_MESSAGE = "Email is already Registered. Please try to Login or use Forgot Password.";
    public static final Integer TOKEN_EXPIRATION_TIME_IN_MINUTES = 16;
    public static final String NULL_REGISTRATION_COMPLETE_TOKEN = "Link is invalid or distorted";
    public static final String USER_NOT_FOUND_EXCEPTION = "User not found";
    public static final String GATEWAY_HEADER = "authorization-key";
    public static final String GATEWAY_SECRET = "$2a$10$NyPXgy6KHrLTA1G9MUUTF.0H8d5R3jbYp0R9n0hewfireuixMGtKS";
    public static final String DIRECT_CALL_VALIDATION_RESPONSE = "Direct call not allowed. Please use api gateway to use this service";

    public static final String ROLES_NOT_PRESENT_TO_ADD = "Please check the available roles to assign";
}
