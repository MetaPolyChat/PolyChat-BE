package com.polychat.polychatbe.friend.command.domain;

import com.polychat.polychatbe.friend.command.application.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.command.domain.service.FriendRequestAcceptService;
import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FriendTest {

    @Autowired
    private FriendService friendService;
    @Autowired
    FriendSearchService friendSearchService;
    @Autowired
    FriendRequestAcceptService friendRequestAcceptService;


    @DisplayName("친구 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "2,3"})
    @Transactional
    public void findFriendTest(int user1, int user2){
        Assertions.assertDoesNotThrow(
                ()->{

                    FriendResponseDTO friendInfo = friendSearchService.findFriendByUserId(user1, user2);
                    System.out.println(friendInfo);
                }
        );
    }

    @DisplayName("친구 등록 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "2,3", "4,3"})
    @Transactional
    public void addFriendTest(int user1, int user2){

        Assertions.assertDoesNotThrow(
                ()->friendService.addFriend(user1, user2)
        );

    }

    @DisplayName("자신을 대상으로 친구 등록 테스트")
    @ParameterizedTest
    @CsvSource({"1,1", "3,3"})
    @Transactional
    public void addSameUserTest(int user1, int user2){

        IllegalArgumentException error = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->friendService.addFriend(user1, user2)
        );

        Assertions.assertEquals(error.getMessage(), "자신을 친구로 추가할 수 없습니다.");
    }

    @DisplayName("삭제 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "5,8"})
    @Transactional
    public void deleteFriendTest(int user1, int user2){

        Assertions.assertDoesNotThrow(
                ()->friendService.deleteFriendByUserId(user1, user2)
        );

        System.out.println(friendSearchService.findAllFriend());
    }

    @DisplayName("친구요청 수락에 의한 등록 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "3,4"})
    @Transactional
    public void friendAcceptTest(int user1, int user2){

        FriendRequest friendRequest = new FriendRequest(
                user1, user2, RequestStatus.ACCEPTED
        );

        Assertions.assertDoesNotThrow(
                ()->friendRequestAcceptService.acceptFriendRequest(friendRequest)
        );

        System.out.println(friendSearchService.findAllFriend());
    }

    @DisplayName("친구요청 미수락 등록 시도 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "3,4"})
    @Transactional
    public void friendNotAcceptTest(int user1, int user2){

        FriendRequest friendRequest = new FriendRequest(
                user1, user2, RequestStatus.PENDING
        );

        IllegalArgumentException failException  = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->friendRequestAcceptService.acceptFriendRequest(friendRequest)
        );

        Assertions.assertEquals("승인되지 않은 친구 신청입니다.", failException.getMessage());
    }

}
