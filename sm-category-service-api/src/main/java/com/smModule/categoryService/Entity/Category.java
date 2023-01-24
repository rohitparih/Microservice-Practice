package com.smModule.categoryService.Entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author : Rohit Parihar
 * Date : 11/21/2022
 * Time : 12:23 AM
 * Class : category
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String categoryId;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private String createdBy;
    private String updatedBy;

    @Column(updatable = false)
    private Date dateCreated;
    private Date lastModified;
}
