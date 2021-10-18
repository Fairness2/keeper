package com.geekbrains.keeper.models.dto;

import com.geekbrains.keeper.models.Note;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class NoteDto {
    private Integer id;
    private String title;
    private String description;
    private List<TagDto> tags;

    public NoteDto(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.description = note.getDescription();
        this.tags = note.getTags().stream().map(TagDto::new).collect(Collectors.toList());
    }
}
