package com.smModule.tagService.Implementation;

import com.smModule.tagService.Entity.Tag;
import com.smModule.tagService.Repository.tagRepository;
import com.smModule.tagService.Service.tagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 8:17 PM
 * Class : tagImplementation
 * Project : Bloggios-Backend
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class tagImplementation implements tagService {

    private final tagRepository tagRepository;

    @Override
    public List<Tag> checkAddTags(List<String> tags) {
        Map<Boolean, List<String>> splittedTags = tags
                .stream()
                .collect(Collectors.partitioningBy(tagRepository::existsByTagName));
        List<Tag> savedTagList = splittedTags
                .get(false)
                .stream()
                .map(e -> tagRepository.save(Tag
                        .builder()
                        .tagName(e)
                        .dateCreated(new Date())
                        .build()))
                .collect(Collectors.toList());
        List<Tag> existedTagList = splittedTags
                .get(true)
                .stream()
                .map(tagRepository::findByTagName)
                .collect(Collectors.toList());
        return Stream
                .concat(savedTagList.stream(), existedTagList.stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTagsName(List<String> tagId) {
        List<Tag> byTagNameIn = tagRepository.findByTagIdIn(tagId);
        return byTagNameIn.stream().map(Tag::getTagName).collect(Collectors.toList());
    }
}
