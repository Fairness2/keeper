package com.geekbrains.keeper.services;


import com.geekbrains.keeper.models.dto.MeetingDto;
import com.geekbrains.keeper.models.entities.Meeting;
import com.geekbrains.keeper.templates.MeetingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeetingService {

    @Autowired
    private MeetingTemplate meetingTemplate;

    public Integer createMeeting(MeetingDto meetingDto) {
        Meeting meeting = new Meeting(meetingDto);
        meetingTemplate.add(meeting);
        return meeting.getId();
    }
}
