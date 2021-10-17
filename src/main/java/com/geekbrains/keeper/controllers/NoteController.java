package com.geekbrains.keeper.controllers;

import com.geekbrains.keeper.models.dto.NoteDto;
import com.geekbrains.keeper.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public Integer addNote(@RequestBody NoteDto note) {
        return noteService.createNote(note).getId();
    }

    @PostMapping("/meetings")
    public List<NoteDto> addNote() {
        return noteService.getMeetingsAsNote();
    }
}
