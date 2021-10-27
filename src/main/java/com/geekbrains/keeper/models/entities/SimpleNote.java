package com.geekbrains.keeper.models.entities;

import com.geekbrains.keeper.models.Note;
import com.geekbrains.keeper.models.entities.Tag;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "simple_note")
public class SimpleNote implements Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @ManyToMany
    @JoinTable(
            name = "ref_simple_note_simple_tag",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
