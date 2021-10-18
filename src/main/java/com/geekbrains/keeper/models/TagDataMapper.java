package com.geekbrains.keeper.models;

import com.geekbrains.keeper.models.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDataMapper {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Tag findById(Integer id) {
        Tag tag = TagIdentityMap.getIdentity(id);
        if (tag != null) {
            return tag;
        }
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        tag = jdbcTemplate.queryForObject("SELECT * FROM tag WHERE id = :id", parameters, new TagRowMapper());
        TagIdentityMap.addIdentity(tag);
        return tag;
    }

    public List<Tag> findAll() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        List<Tag> list = jdbcTemplate.query("SELECT * FROM tag",parameters, new TagRowMapper());
        list.forEach(TagIdentityMap::addIdentity);
        return list;
    }

    public boolean save(Tag tag) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", tag.getName());
        int res = 0;
        if (tag.getId() != null) {
            parameters.addValue("id", tag.getId());
            res = jdbcTemplate.update("UPDATE tag SET name = :name WHERE id = :id", parameters);
        }
        else {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            res = jdbcTemplate.update("INSERT INTO tag (name) VALUES (:name);", parameters, keyHolder);
            tag.setId(keyHolder.getKey().intValue());
        }

        if (res > 0) {
            TagIdentityMap.addIdentity(tag);
            return true;
        }
        else {
            return false;
        }
    }
}
