package com.geekbrains.keeper.models.entities;

import com.geekbrains.keeper.models.dto.MeetingDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "simple_meeting")
@NoArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @ManyToMany
    @JoinTable(
            name = "ref_simple_meeting_simple_tag",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    @Column(name = "date_start")
    private LocalDateTime dateStart;
    @Column(name = "date_end")
    private LocalDateTime dateEnd;
    @ManyToMany
    @JoinTable(
            name = "ref_simple_meeting_user",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Meeting(MeetingDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m d.M.y");
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.tags = dto.getTags().stream().map(Tag::new).collect(Collectors.toList());
        this.users = dto.getUsers().stream().map(User::new).collect(Collectors.toList());
        this.author = new User(dto.getAuthor());
        this.dateStart = LocalDateTime.parse(dto.getDateStart(), formatter);
        this.dateEnd = LocalDateTime.parse(dto.getDateStart(), formatter);
    }
}
