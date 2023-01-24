package Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Rohit Parihar
 * Date : 11/24/2022
 * Time : 4:11 PM
 * Class : ApiResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    String message;
    Boolean success;
}
