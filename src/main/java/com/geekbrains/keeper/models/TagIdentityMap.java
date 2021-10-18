package com.geekbrains.keeper.models;

import com.geekbrains.keeper.models.entities.Tag;

import java.util.HashMap;
import java.util.Map;

public class TagIdentityMap {
    private static final Map<Integer, Tag> identities = new HashMap<>();

    public static Tag getIdentity(Integer id) {
        return identities.get(id);
    }

    public static void addIdentity(Tag tag) {
        identities.put(tag.getId(), tag);
    }
}
