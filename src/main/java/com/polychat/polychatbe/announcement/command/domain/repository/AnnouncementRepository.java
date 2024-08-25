package com.polychat.polychatbe.announcement.command.domain.repository;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
