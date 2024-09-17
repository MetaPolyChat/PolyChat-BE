package com.polychat.polychatbe.announcement.query.repository;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnnouncementSearchRepository {

    List<AnnouncementResponseDTO> findAllAnnouncement();

    List<AnnouncementResponseDTO> findAllAnnouncement(SearchCriteriaInfo searchCriteriaInfo);

    Optional<AnnouncementResponseDTO> findAnnouncementById(Long announcementId);

}
