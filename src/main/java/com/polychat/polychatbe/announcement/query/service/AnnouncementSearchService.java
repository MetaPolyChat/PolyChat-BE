package com.polychat.polychatbe.announcement.query.service;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.repository.AnnouncementSearchRepository;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnnouncementSearchService {

    private AnnouncementSearchRepository announcementSearchRepository;

    public AnnouncementSearchService(AnnouncementSearchRepository announcementSearchRepository) {
        this.announcementSearchRepository = announcementSearchRepository;
    }

    public AnnouncementResponseDTO findAnnouncementById(long announcementId){
        AnnouncementResponseDTO announcement = announcementSearchRepository.findAnnouncementById(announcementId)
                .orElseThrow(()-> new NoSuchElementException("존재하지 않는 공지"));

        return announcement;
    }

    public List<AnnouncementResponseDTO> findAllAnnouncement() {

        return announcementSearchRepository.findAllAnnouncement();
    }

    public List<AnnouncementResponseDTO> findAnnouncementList(SearchCriteriaInfo searchCriteriaInfo) {
        return announcementSearchRepository.findAllAnnouncement(searchCriteriaInfo);
    }

}
