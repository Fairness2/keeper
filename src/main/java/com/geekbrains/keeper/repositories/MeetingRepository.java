package com.geekbrains.keeper.repositories;

import com.geekbrains.keeper.models.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
