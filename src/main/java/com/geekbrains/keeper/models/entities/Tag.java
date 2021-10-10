package com.geekbrains.keeper.models.entities;

import com.geekbrains.keeper.models.dto.TagDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "simple_tag")
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "ref_simple_note_simple_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id"))
    private List<SimpleNote> notes;

    public Tag (TagDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }
}
