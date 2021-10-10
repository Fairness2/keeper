package com.geekbrains.keeper.repositories;

import com.geekbrains.keeper.models.entities.SimpleNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleNoteRepository extends JpaRepository<SimpleNote, Integer> {
}
