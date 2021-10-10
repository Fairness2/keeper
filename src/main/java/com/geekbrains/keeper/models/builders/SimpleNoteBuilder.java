package com.geekbrains.keeper.models.builders;

import com.geekbrains.keeper.models.Note;
import com.geekbrains.keeper.models.entities.SimpleNote;
import com.geekbrains.keeper.models.entities.Tag;
import com.geekbrains.keeper.repositories.SimpleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SimpleNoteBuilder implements NoteBuilder{

    private final SimpleNote note;

    public SimpleNoteBuilder(){
        this.note = new SimpleNote();
    }

    @Override
    public NoteBuilder id(int id) {
        note.setId(id);
        return this;
    }

    @Override
    public NoteBuilder title(String title) {
        note.setTitle(title);
        return this;
    }

    @Override
    public NoteBuilder description(String description) {
        note.setDescription(description);
        return this;
    }

    @Override
    public NoteBuilder tags(List<Tag> tags) {
        note.setTags(tags);
        return this;
    }

    @Override
    public Note build() {
        return note;
    }
}
