package com.smModule.tagService.Entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 5:56 PM
 * Class : Tag
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String tagId;

    @Column(nullable = false, updatable = false, length = 40)
    private String tagName;
    private Date dateCreated;
}
