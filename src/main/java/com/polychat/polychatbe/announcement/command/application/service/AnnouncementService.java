package com.polychat.polychatbe.announcement.command.application.service;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.dto.AnnouncementDeleteRequest;
import com.polychat.polychatbe.announcement.command.application.dto.AnnouncementUpdateDTO;
import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import com.polychat.polychatbe.announcement.command.domain.repository.AnnouncementRepository;
import com.polychat.polychatbe.announcement.command.domain.service.AnnouncementDomainService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementService {

    private AnnouncementDomainService announcementDomainService;
    private AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementDomainService announcementDomainService) {
        this.announcementRepository = announcementRepository;
        this.announcementDomainService = announcementDomainService;
    }

    @Transactional
    public void addAnnouncement(AnnounceAddRequest announceAddRequest) {
        Announcement announcement = AnnounceAddRequest.announcementFromDto(announceAddRequest);
        announcementRepository.save(announcement);
    }

    @Transactional
    public void updateAnnouncement(AnnouncementUpdateDTO updateRequest) {
        Long requestAnnouncementId = updateRequest.getAnnouncementId();
        if (requestAnnouncementId == null) {
            throw new IllegalArgumentException("업데이트할 대상을 지정해 주세요");
        }

        Announcement foundAnnouncement = announcementRepository.findById(requestAnnouncementId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디"));

        if (announcementDomainService.isNotAuthorized(foundAnnouncement, requestAnnouncementId)) {
            throw new IllegalArgumentException("업데이트 권한이 없습니다.");
        }

        foundAnnouncement.updateAnnouncement(
                updateRequest.getTitle(),
                updateRequest.getContent(),
                LocalDateTime.now()
        );
    }

    @Transactional
    public void deleteAnnouncement(long announcementId, AnnouncementDeleteRequest deleteInfo) {
        announcementDomainService.deleteAnnouncement(announcementId, deleteInfo.getUserNo());
    }


}
