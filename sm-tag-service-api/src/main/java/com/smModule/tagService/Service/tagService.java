package com.smModule.tagService.Service;

import com.smModule.tagService.Entity.Tag;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 6:39 PM
 * Class : tagService
 * Project : Bloggios-Backend
 */

public interface tagService {
    List<Tag> checkAddTags(List<String> tags);
    List<String> getTagsName(List<String> tagId);
}
