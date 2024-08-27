package com.polychat.polychatbe.announcement.command.domain.service;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import com.polychat.polychatbe.announcement.command.domain.repository.AnnouncementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementDomainService {

    private AnnouncementRepository announcementRepository;

    public AnnouncementDomainService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public boolean checkModifyAuthority(Announcement announcement, long requestUploaderId){
        return announcement.getUploaderId() == requestUploaderId;
    }




    @Transactional
    public void deleteAnnouncement(long announcementId, long uploaderId) {
        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 아이디"));

        if (!checkModifyAuthority(announcement, uploaderId)){
            throw new IllegalArgumentException("삭제 권한이 없습니다.");
        }

        announcementRepository.deleteById(announcementId);
    }

}
