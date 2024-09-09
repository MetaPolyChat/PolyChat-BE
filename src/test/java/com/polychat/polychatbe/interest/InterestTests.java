package com.polychat.polychatbe.interest;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import com.polychat.polychatbe.user.command.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class InterestTests {

    @Autowired
    private InterestService interestService;

    @Autowired
    private UserInterestService userInterestService;

    private static Stream<Arguments> createUserInterest() {
        return Stream.of(
                Arguments.of(
                        new User("hong", "홍길동"),
                        new Interest("Coding")
                ),
                Arguments.of(
                        new User("lee", "이순신"),
                        new Interest("Trip")
                )
        );
    }

    @DisplayName("유저 관심사 테이블 생성 테스트")
    @ParameterizedTest
    @MethodSource("createUserInterest")
    public void testCreateUserInterest(User user, Interest interest) {


        Assertions.assertDoesNotThrow(() -> userInterestService.registUserInterest(user, interest));
    }


    @DisplayName("관심사 CRUD 테스트")
    @ParameterizedTest
    @MethodSource("createUserInterest")
    public void testInterest(String name) {


        Assertions.assertDoesNotThrow(() -> interestService.registInterest(name));
        Assertions.assertDoesNotThrow(() -> interestService.updateInterest(name));
//        Assertions.assertDoesNotThrow(() -> interestService.findInterestByInterestName(name));
//        Assertions.assertDoesNotThrow(() -> interestService.removeInterest(name));

    }

}
