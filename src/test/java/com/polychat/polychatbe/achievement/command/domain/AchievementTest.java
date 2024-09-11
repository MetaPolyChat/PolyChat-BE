package com.polychat.polychatbe.achievement.command.domain;

import com.polychat.polychatbe.achievement.command.application.dto.AchievementRequest;
import com.polychat.polychatbe.achievement.command.application.service.AchievementService;
import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import com.polychat.polychatbe.achievement.command.domain.service.AchievementDomainService;
import com.polychat.polychatbe.achievement.query.service.AchievementSearchService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

@SpringBootTest
public class AchievementTest {

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private AchievementDomainService achievementDomainService;

    @Autowired
    private AchievementSearchService achievementSearchService;

    @Autowired
    private EntityManager em;

    private static Stream<Arguments> addAchievementData() {
        return Stream.of(
                Arguments.of(
                        "고정 방문자","2주 연속으로 폴리챗에 방문하세요.",
                        "2주 연속 접속",  null

                ),
                Arguments.of(
                                "인테리어 장인","당신의 방에 15개의 가구를 배치하세요.",
                                "방 가구 15개 배치하기",  null
                )
        );
    }

    @DisplayName("업적 등록 테스트")
    @ParameterizedTest
    @MethodSource("addAchievementData")
    @Transactional
    public void addAchievementTest(String achievementName, String achievementDescription
            ,String achievementCondition, MultipartFile achievementImage){

        AchievementRequest achievementRequest = new AchievementRequest(
                achievementName, achievementDescription, achievementCondition, achievementImage
        );

        Assertions.assertDoesNotThrow(
                ()-> achievementService.addAchievement(achievementRequest)
        );

    }


    private static Stream<Arguments> updateAchievementData() {
        return Stream.of(
                Arguments.of(
                        1L,
                                "고정 방문자","3주 연속으로 폴리챗에 방문하세요.",
                                "3주 연속 접속",  null
                ),
                Arguments.of(
                        2L,
                                "인테리어 달인","당신의 방에 18개의 가구를 배치하세요.",
                                "방 가구 18개 배치하기",  null
                )
        );
    }


    @DisplayName("업적 업데이트 테스트")
    @ParameterizedTest
    @MethodSource("updateAchievementData")
    @Transactional
    public void updateAchievementTest(Long achievementId, String achievementName, String achievementDescription
            ,String achievementCondition, MultipartFile achievementImage){

        AchievementRequest modifiedAchievementRequest = new AchievementRequest(
                achievementId, achievementName, achievementDescription, achievementCondition, achievementImage
        );


        Assertions.assertDoesNotThrow(
                ()-> achievementService.updateAchievement(modifiedAchievementRequest)
        );

        em.flush();
        em.clear();

        System.out.println(achievementSearchService.findAllAchievement());
    }

    
    @DisplayName("업적 삭제 테스트")
    @ParameterizedTest
    @CsvSource({"1","2"})
    @Transactional
    public void deleteAchievementTest(long achievementId) {

        Assertions.assertDoesNotThrow(
                ()->achievementService.deleteAchievement(achievementId)
        );

        // jpa로 수정하고 mybatis로 조회 시도할때는
        // 영속성 컨텍스트가 db에 아직 반영되지 않아서 수동으로 반영
        em.flush();
        em.clear();

        Assertions.assertNull(
                achievementSearchService.findAchievementById(achievementId)
        );
    }

}
