package com.geekbrains.keeper.models.dto;

import com.geekbrains.keeper.models.entities.Tag;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDto {
    private Integer id;
    private String name;

    public TagDto(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
    }
}
