package com.geekbrains.keeper.services;

import com.geekbrains.keeper.models.TagDataMapper;
import com.geekbrains.keeper.models.dto.TagDto;
import com.geekbrains.keeper.models.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private TagDataMapper tagDataMapper;

    public Integer createTag(TagDto tagDto) {
        Tag tag = new Tag(tagDto);
        tagDataMapper.save(tag);
        return tagDataMapper.save(tag) ? tag.getId() : null;
    }

    public List<TagDto> getTags() {
        List<Tag> list = tagDataMapper.findAll();
        return list.stream()
                .map(TagDto::new)
                .collect(Collectors.toList());
    }

    public TagDto getTag(int id) {
        Tag tag = tagDataMapper.findById(id);
        return tag != null ? new TagDto(tag) : null;
    }
}
