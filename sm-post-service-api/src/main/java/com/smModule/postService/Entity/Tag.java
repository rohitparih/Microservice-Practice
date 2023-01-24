package com.smModule.postService.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 3:37 PM
 * Class : Tag
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tag {
    @Id
    private String tagId;
    private String tagName;
}
