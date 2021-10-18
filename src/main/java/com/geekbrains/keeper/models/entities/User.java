package com.geekbrains.keeper.models.entities;

import com.geekbrains.keeper.models.Note;
import com.geekbrains.keeper.models.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (
            name = "ref_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(UserDto dto) {
        this.id = dto.getId();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
    }
}
