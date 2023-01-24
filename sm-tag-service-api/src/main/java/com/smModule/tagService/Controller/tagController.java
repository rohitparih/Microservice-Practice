package com.smModule.tagService.Controller;

import com.smModule.tagService.Config.CustomPrincipal;
import com.smModule.tagService.Entity.Tag;
import com.smModule.tagService.Service.tagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 8:16 PM
 * Class : tagController
 * Project : Bloggios-Backend
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sm-tags")
@Slf4j
public class tagController {

    private final tagService tagService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tag> checkAddTags(@RequestBody List<String> tags){
        log.error("Incoming Request");
        List<Tag> allTags = this.tagService.checkAddTags(tags);
        log.warn("Sending Tags list of size {}", allTags.size());
        return allTags;
    }

    @PostMapping("/name")
    public List<String> tagsName(@RequestBody List<String> tagId){
        List<String> tagsName = tagService.getTagsName(tagId);
        return tagsName;
    }
}
