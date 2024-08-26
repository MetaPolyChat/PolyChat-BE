package com.polychat.polychatbe.announcement.query.repository;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementSearchRepository extends JpaRepository<Announcement, Long> {
}
