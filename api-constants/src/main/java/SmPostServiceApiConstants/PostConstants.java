package SmPostServiceApiConstants;

/**
 * Author : Rohit Parihar
 * Date : 11/28/2022
 * Time : 12:48 AM
 * Class : PostConstants
 * Project : Bloggios-Backend
 */

public class PostConstants {
    public static final String POST_SAVED = "Post Created";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String NOT_MATCHED = "User and Category not found with given input";
    public static final String POST_NOT_FOUND = "Post not found with Post Id";
    public static final String CREATE_POST_FALLBACK = "Something went wrong on server side. Please try again after sometime";
    public static final String GATEWAY_HEADER = "authorization-key";
    public static final String GATEWAY_SECRET = "$2a$10$SiVm8UP7Ih5v8q3qPmOZhugzCRubRj4GWuEdzDsTHt2oGae/ftW8q";
    public static final String DIRECT_CALL_VALIDATION_RESPONSE = "Direct call not allowed. Please use api gateway to use this service";
}
