package com.smModule.postService.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 3:12 PM
 * Class : postEntity
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String postId;

    @Column(nullable = false)
    private String caption;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "post", referencedColumnName = "postId"), inverseJoinColumns = @JoinColumn(name = "tag", referencedColumnName = "tagId"))
    private List<Tag> tags;

    @Column(nullable = false, updatable = false)
    private String userId;

    private String categoryId;
    private Date dateCreated;
    private Date lastEdited;
    private Boolean isDeleted;
    private Boolean isBlocked;
}
