package com.smModule.tagService.Repository;

import com.smModule.tagService.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 8:19 PM
 * Class : tagRepository
 * Project : Bloggios-Backend
 */

public interface tagRepository extends JpaRepository<Tag, String> {
    Boolean existsByTagName(String name);
    Tag findByTagName(String tagName);
    List<Tag> findByTagIdIn(List<String> tagId);
}
