package com.geekbrains.keeper.models;

import com.geekbrains.keeper.models.entities.Meeting;
import com.geekbrains.keeper.models.entities.Tag;
import com.geekbrains.keeper.models.entities.User;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MeetingToNoteAdapter implements Note{
    private final Meeting meeting;

    public MeetingToNoteAdapter(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m d d.M.y");
        return String.format("Начало в %s, конец - %s", meeting.getDateStart().format(formatter), meeting.getDateEnd().format(formatter));
    }

    @Override
    public String getTitle() {
        return meeting.getTitle();
    }

    @Override
    public List<Tag> getTags() {
        return meeting.getTags();
    }

    @Override
    public Integer getId() {
        return meeting.getId();
    }

    @Override
    public User getUser() {
        return meeting.getUser();
    }
}
