package com.polychat.polychatbe.friendRequest.query.service;

//import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.query.dto.FriendRequestInfoDTO;
import com.polychat.polychatbe.friendRequest.query.repository.FriendRequestSearchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendRequestSearchService {

    private FriendRequestSearchRepository friendRequestSearchRepository;

    public FriendRequestSearchService(FriendRequestSearchRepository friendRequestSearchRepository) {
        this.friendRequestSearchRepository = friendRequestSearchRepository;
    }

    public List<FriendRequestInfoDTO> findAllFriendRequest() {
        return friendRequestSearchRepository.findAll()
                .stream()
                .map((request)-> new FriendRequestInfoDTO(
                        request.getFriendRequestId(),
                        request.getSender(),
                        request.getReceiver(),
                        request.getStatus()))
                .collect(Collectors.toList());
    }

    public List<FriendRequestInfoDTO> findFriendRequestBySender(int sender) {
        return friendRequestSearchRepository.findBySender(sender)
                .stream()
                .map(FriendRequestInfoDTO::new)
                .collect(Collectors.toList());
    }

    public FriendRequestInfoDTO findFriendRequestById(long id) {

        FriendRequest request = friendRequestSearchRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        return new FriendRequestInfoDTO(request);
    }

}
