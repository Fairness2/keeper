package com.geekbrains.keeper.controllers;

import com.geekbrains.keeper.models.dto.TagDto;
import com.geekbrains.keeper.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/add")
    public Integer addNote(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @PostMapping
    public List<TagDto> getTags() {
        return tagService.getTags();
    }

    @PostMapping("/{id}")
    public TagDto getTag(@PathVariable Integer id) {
        return tagService.getTag(id);
    }
}
