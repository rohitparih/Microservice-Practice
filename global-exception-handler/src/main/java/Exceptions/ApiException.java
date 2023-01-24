package Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Author : Rohit Parihar
 * Date : 11/24/2022
 * Time : 4:24 PM
 * Class : badRequestException
 * Project : Bloggios-Backend
 */

@Getter
@Setter
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;


    public ApiException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
