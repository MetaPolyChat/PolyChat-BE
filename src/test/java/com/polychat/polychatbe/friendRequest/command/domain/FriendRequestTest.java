package com.polychat.polychatbe.friendRequest.command.domain;

import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import com.polychat.polychatbe.friendRequest.query.service.FriendRequestSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
public class FriendRequestTest {

    @Autowired
    private FriendRequestService friendRequestService;
    @Autowired
    private FriendRequestSearchService friendRequestSearchService;


    @DisplayName("친구 요청 등록 테스트")
    @ParameterizedTest
    @CsvSource({"1,2", "2,3", "4,3"})
    @Transactional
    public void addFriendRequestTest(int senderId, int receiverId){

        Assertions.assertDoesNotThrow(
                ()->{
                    friendRequestService.addFriendRequest(
                            new FriendRequestDTO(senderId, receiverId, RequestStatus.PENDING)
                    );
                }
        );
    }

    @DisplayName("자신 친구 요청 등록 테스트")
    @ParameterizedTest
    @CsvSource({"1,1", "3,3"})
    public void addSameUserRequestTest(int senderId, int receiverId){

        Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->{
                    friendRequestService.addFriendRequest(
                            new FriendRequestDTO(senderId, receiverId, RequestStatus.PENDING)
                    );
                }
        );

    }

    private static Stream<Arguments> notAcceptStatus() {
        return Stream.of(
                Arguments.of(1, RequestStatus.CANCELED),
                Arguments.of(2,RequestStatus.REJECTED)
        );
    }

    private static Stream<Arguments> acceptStatus() {
        return Stream.of(
                Arguments.of(1, RequestStatus.ACCEPTED),
                Arguments.of(2,RequestStatus.ACCEPTED)
        );
    }

    @DisplayName("친구 요청 미수락 테스트")
    @ParameterizedTest
    @MethodSource("notAcceptStatus")
    @Transactional
    void notAcceptRequestTest(int requestId, RequestStatus status){
        Assertions.assertDoesNotThrow(
                ()->{
                    friendRequestService.updateFriendRequestStatus(
                            new FriendRequestStatusDTO(requestId, status)
                    );
                }
        );

    }

    @DisplayName("친구 요청 수락 테스트")
    @ParameterizedTest
    @MethodSource("acceptStatus")
    @Transactional
    void acceptRequestTest(int requestId, RequestStatus status){
                Assertions.assertDoesNotThrow(
                ()->{
                    friendRequestService.updateFriendRequestStatus(
                            new FriendRequestStatusDTO(requestId, status)
                    );
                }
        );

    }

    @DisplayName("친구 요청 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,3})
    @Transactional
    void removeRequestTest(int requestId){
        Assertions.assertDoesNotThrow(
                () ->{
                    friendRequestService.deleteFriendRequest(requestId);
                }
        );
        System.out.println(friendRequestSearchService.findAllFriendRequest());
    }

}
