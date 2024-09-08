package com.polychat.polychatbe.friendRequest.query.service;

//import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friendRequest.query.dto.FriendRequestInfoDTO;
import com.polychat.polychatbe.friendRequest.query.dto.UserFriendRequestDTO;
import com.polychat.polychatbe.friendRequest.query.repository.FriendRequestSearchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FriendRequestSearchService {

    private FriendRequestSearchRepository friendRequestSearchRepository;

    public FriendRequestSearchService(FriendRequestSearchRepository friendRequestSearchRepository) {
        this.friendRequestSearchRepository = friendRequestSearchRepository;
    }

    public List<FriendRequestInfoDTO> findAllFriendRequest() {
        return friendRequestSearchRepository.findAllFriendRequest();
    }

    public List<UserFriendRequestDTO> findFriendRequestBySender(int sender) {
        return friendRequestSearchRepository.findFriendRequestBySender(sender);
    }

    public FriendRequestInfoDTO findFriendRequestById(long id) {

        FriendRequestInfoDTO friendRequestInfo = friendRequestSearchRepository.findFriendRequestById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 아이디가 존재하지 않습니다"));

        return friendRequestInfo;
    }

}
