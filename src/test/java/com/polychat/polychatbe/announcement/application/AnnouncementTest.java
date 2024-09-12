package com.polychat.polychatbe.announcement.application;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.service.AnnouncementService;
import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import com.polychat.polychatbe.announcement.query.service.AnnouncementSearchService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class AnnouncementTest {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private AnnouncementSearchService announcementSearchService;


    private static Stream<Arguments> addAnnouncementSource() {
        return Stream.of(
                Arguments.of(
                        1L, "점검 시간 안내",
                                "몇시부터 몇시까지 점검함",
                                LocalDateTime.of(2024, 8, 24, 13, 19)),
                Arguments.of(1L, "주의 사항 안내",
                                "매너있게 활동", LocalDateTime.now(), null)
                );
    }
    @DisplayName("공지사항 등록 테스트")
    @ParameterizedTest
    @MethodSource("addAnnouncementSource")
    @Transactional
    public void addAnnouncementTest (Long uploaderId, String title, String content, LocalDateTime uploadTime){
        AnnounceAddRequest announceAddRequest = new AnnounceAddRequest(
                uploaderId, title, content, uploadTime, null
        );

        Assertions.assertDoesNotThrow(
                () -> announcementService.addAnnouncement(announceAddRequest)
        );

        System.out.println(announcementSearchService.findAllAnnouncement());
    }

    @DisplayName("공지사항 삭제 테스트")
    @Transactional
    @ParameterizedTest
    @CsvSource({"5,1", "6,3"})
    public void deleteAnnouncement (Long announcementId, Long uploaderId) {
        Assertions.assertDoesNotThrow(
                () -> announcementService.deleteAnnouncement(announcementId, uploaderId)
        );

        System.out.println(announcementSearchService.findAllAnnouncement());
    }

    @DisplayName("권한이 없는 사람이 공지사항 삭제 시도")
    @Transactional
    @ParameterizedTest
    @CsvSource({"5,2", "6,5"})
    public void deleteAnnouncementNotMatchUser (Long announcementId, Long uploaderId) {
        IllegalArgumentException notMatchException=
                Assertions.assertThrows(IllegalArgumentException.class,
                () -> announcementService.deleteAnnouncement(announcementId, uploaderId)
        );

        Assertions.assertEquals("삭제 권한이 없습니다.", notMatchException.getMessage());

    }


}
