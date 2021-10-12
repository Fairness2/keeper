package com.geekbrains.keeper.services;

import com.geekbrains.keeper.models.MeetingToNoteAdapter;
import com.geekbrains.keeper.models.Note;
import com.geekbrains.keeper.models.builders.NoteBuilder;
import com.geekbrains.keeper.models.builders.SimpleNoteBuilder;
import com.geekbrains.keeper.models.dto.NoteDto;
import com.geekbrains.keeper.models.entities.Meeting;
import com.geekbrains.keeper.models.entities.SimpleNote;
import com.geekbrains.keeper.models.entities.Tag;
import com.geekbrains.keeper.repositories.MeetingRepository;
import com.geekbrains.keeper.repositories.SimpleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private SimpleNoteRepository simpleNoteRepository;
    @Autowired
    private MeetingRepository meetingRepository;

    public NoteDto createNote(NoteDto noteDto) {
        NoteBuilder builder = new SimpleNoteBuilder();
        Note note = builder.title(noteDto.getTitle())
                .description(noteDto.getDescription())
                .tags(noteDto.getTags().stream().map(Tag::new).collect(Collectors.toList()))
                .build();
        simpleNoteRepository.save((SimpleNote) note); //TODO плохой пример)))
        return new NoteDto(note);
    }

    public List<NoteDto> getMeetingsAsNote() {
        List<Meeting> list = meetingRepository.findAll();
        return list.stream()
                .map(MeetingToNoteAdapter::new)
                .map(NoteDto::new)
                .collect(Collectors.toList());
    }
}
