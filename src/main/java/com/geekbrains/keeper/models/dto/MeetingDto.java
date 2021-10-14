package com.geekbrains.keeper.models.dto;

import com.geekbrains.keeper.models.entities.Meeting;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class MeetingDto {
    private Integer id;
    private String title;
    private List<TagDto> tags;
    private String dateStart;
    private String dateEnd;
    private List<UserDto> users;
    private UserDto author;

    public MeetingDto(Meeting meeting) {
        this.id = meeting.getId();
        this.title = meeting.getTitle();
        this.tags = meeting.getTags().stream().map(TagDto::new).collect(Collectors.toList());
        this.users = meeting.getUsers().stream().map((user) -> UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build()
        ).collect(Collectors.toList());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m d.M.y");
        this.dateEnd = meeting.getDateEnd().format(formatter);
        this.dateStart = meeting.getDateStart().format(formatter);
        this.author = UserDto.builder()
                .id(meeting.getAuthor().getId())
                .username(meeting.getAuthor().getUsername())
                .build();
    }
}
