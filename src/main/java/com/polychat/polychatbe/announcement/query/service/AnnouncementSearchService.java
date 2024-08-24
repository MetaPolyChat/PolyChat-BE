package com.polychat.polychatbe.announcement.query.service;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.repository.AnnouncementSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementSearchService {

    private AnnouncementSearchRepository announcementSearchRepository;

    public AnnouncementSearchService(AnnouncementSearchRepository announcementSearchRepository) {
        this.announcementSearchRepository = announcementSearchRepository;
    }

    public AnnouncementResponseDTO findAnnouncementById(long announcementId){
        AnnouncementResponseDTO announcement = new AnnouncementResponseDTO(announcementSearchRepository.findById(announcementId)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 공지")));

        return announcement;
    }

    public List<AnnouncementResponseDTO> findAllAnnouncement() {

        return announcementSearchRepository.findAll()
                .stream()
                .map(AnnouncementResponseDTO::new)
                .collect(Collectors.toList());

    }



}
