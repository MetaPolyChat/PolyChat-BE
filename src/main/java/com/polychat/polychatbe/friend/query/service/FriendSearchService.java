package com.polychat.polychatbe.friend.query.service;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.friend.query.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.repository.FriendMyBatisRepository;
import com.polychat.polychatbe.friend.query.repository.FriendSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FriendSearchService {

    //private FriendSearchRepository friendSearchRepository;
    private FriendMyBatisRepository friendMyBatisRepository;

    public FriendSearchService(FriendMyBatisRepository friendMyBatisRepository) {
        this.friendMyBatisRepository = friendMyBatisRepository;
    }

    public List<FriendResponseDTO> findAllFriend() {
        return friendMyBatisRepository.findAllFriend();
    }

    public FriendResponseDTO findFriendById(long friendId){
        return friendMyBatisRepository.findByFriendId(friendId);

    }

    public List<FriendUserInfoDTO> findUserFriend(long userId) {

        return friendMyBatisRepository.findOneUserFriend(new FriendUserId(userId));
    }

    public List<FriendUserInfoDTO> findUserFriendWithCriteria(long userId, SearchCriteriaInfo searchCriteria) {

        return friendMyBatisRepository.findOneUserFriend(new FriendUserId(userId));
    }

    public FriendResponseDTO findFriendByUserId(long user1, long user2){
//        Friend friendInfo = friendSearchRepository.findByUser1AndUser2(
////                new FriendUserId(user1),
////                new FriendUserId(user2)
////        );
////
////        if (friendInfo==null){
////            return null;
////        }
//        return new FriendResponseDTO(
//                friendInfo.getFriendId(),
//                friendInfo.getUser1().getFriendUserId(),
//                friendInfo.getUser2().getFriendUserId()
//        );

        FriendResponseDTO friendResponse = friendMyBatisRepository.findByTwoUser(
                new TwoFriendUserVO(new FriendUserId(user1), new FriendUserId(user2))
        ).orElseThrow(()->new NoSuchElementException("두 유저는 친구 관계가 아닙니다."));

        return friendResponse;
    }

    public FriendResponseDTO findFriendByUserInfo(FriendUserDTO friendUserInfo) {
        return this.findFriendByUserId(friendUserInfo.getUser1(), friendUserInfo.getUser2());
    }

}
