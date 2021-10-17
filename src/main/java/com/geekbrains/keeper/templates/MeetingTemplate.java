package com.geekbrains.keeper.templates;

import com.geekbrains.keeper.models.entities.Meeting;

public abstract class MeetingTemplate {
    public final Integer add(Meeting meeting) {
        save(meeting);
        notifyUsers(meeting);
        return meeting.getId();
    }

    protected abstract void save(Meeting meeting);
    protected abstract void notifyUsers(Meeting meeting);
}
