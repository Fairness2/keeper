package com.geekbrains.keeper.models;

import com.geekbrains.keeper.models.entities.Tag;
import com.geekbrains.keeper.models.entities.User;

import java.util.List;

public interface Note {
    String getDescription();
    String getTitle();
    List<Tag> getTags();
    Integer getId();
    User getUser();
}
