package com.geekbrains.keeper.models.builders;

import com.geekbrains.keeper.models.Note;
import com.geekbrains.keeper.models.entities.Tag;

import java.util.List;

public interface NoteBuilder {
    NoteBuilder id(int id);
    NoteBuilder title(String title);
    NoteBuilder description(String description);
    NoteBuilder tags(List<Tag> tags);
    Note build();
}
