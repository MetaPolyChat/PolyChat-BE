package com.polychat.polychatbe.announcement.command.application.service;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import com.polychat.polychatbe.announcement.command.domain.repository.AnnouncementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementService {

    private AnnouncementRepository announcementRepository;
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Transactional
    public void addAnnouncement(AnnounceAddRequest announceAddRequest){
        Announcement announcement = AnnounceAddRequest.announcementFromDto(announceAddRequest);
        announcementRepository.save(announcement);
    }

    @Transactional
    public void updateAnnouncement(AnnounceAddRequest announceAddRequest) {
        if(announceAddRequest.getAnnouncementId() ==null ){
            throw  new IllegalArgumentException("업데이트할 대상을 지정해 주세요");
        }

        Announcement foundAnnouncement = announcementRepository.findById(announceAddRequest.getAnnouncementId()).orElseThrow(
                ()-> new IllegalArgumentException("업데이트 대상이 존재하지 않습니다.")
        );

        foundAnnouncement.setAnnouncementTitle(announceAddRequest.getTitle());
        foundAnnouncement.setAnnouncementContent(announceAddRequest.getContent());
        foundAnnouncement.setLastUpdatedTime(LocalDateTime.now());

    }

    @Transactional
    public void deleteAnnouncement(long announcementId) {
        announcementRepository.deleteById(announcementId);
    }



}
