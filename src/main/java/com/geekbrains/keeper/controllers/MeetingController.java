package com.geekbrains.keeper.controllers;

import com.geekbrains.keeper.models.dto.MeetingDto;
import com.geekbrains.keeper.models.dto.NoteDto;
import com.geekbrains.keeper.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @PostMapping("/add")
    public Integer addMeeting(@RequestBody MeetingDto meetingDto) {
        return meetingService.createMeeting(meetingDto);
    }
}
