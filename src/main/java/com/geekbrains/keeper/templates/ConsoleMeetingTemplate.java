package com.geekbrains.keeper.templates;

import com.geekbrains.keeper.models.entities.Meeting;
import com.geekbrains.keeper.models.entities.User;
import com.geekbrains.keeper.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ConsoleMeetingTemplate extends MeetingTemplate {
    @Autowired
    private MeetingRepository meetingRepository;
    @Override
    protected void save(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    @Override
    protected void notifyUsers(Meeting meeting) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m d.M.y");
        String dateStart = meeting.getDateStart().format(formatter);
        String dateEnd = meeting.getDateEnd().format(formatter);
        for (User user: meeting.getUsers()) {
            System.out.printf("%s, вы приглашены на встречу %s %s-%s%n", user.getUsername(), meeting.getTitle(), dateStart, dateEnd);
        }
    }
}
