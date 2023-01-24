package com.smModule.postService.Payloads;

import lombok.*;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:35 PM
 * Class : pagedResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class pagedResponse<T> {
    private List<T> pageContents;
    private Long pageNumber;
    private Long pageSize;
    private Long totalElements;
    private Long totalPages;
    private Boolean isFirst;
    private Boolean isLast;
}
