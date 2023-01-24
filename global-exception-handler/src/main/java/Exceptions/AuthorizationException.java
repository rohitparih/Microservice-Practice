package Exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Author : Rohit Parihar
 * Date : 12/18/2022
 * Time : 10:18 PM
 * Class : AuthorizationException
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
public class AuthorizationException extends RuntimeException {
    private HttpStatus status;
    private String message;

    private String errorType;

    public AuthorizationException(HttpStatus status, String message, String errorType) {
        super();
        this.status = status;
        this.message = message;
        this.errorType = errorType;
    }
}
