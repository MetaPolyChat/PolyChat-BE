package com.polychat.polychatbe.announcement.query.repository;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementSearchRepository {

    List<AnnouncementResponseDTO> findAllAnnouncement();

    AnnouncementResponseDTO findAnnouncementById(Long announcementId);
}
