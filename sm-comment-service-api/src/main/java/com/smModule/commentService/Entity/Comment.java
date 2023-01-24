package com.smModule.commentService.Entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author : Rohit Parihar
 * Date : 1/11/2023
 * Time : 3:11 PM
 * Class : Comment
 * Project : Bloggios-Backend
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String commentId;
    private String comment;
    private String userId;
    private Date dateCreated;
    private String postId;
}
