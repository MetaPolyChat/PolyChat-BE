package com.polychat.polychatbe.friend.command.domain.service;

public interface CheckAddRequestService {

    boolean isExistRequest(long friendRequestId);

    boolean isValidRequest(long friendRequestId);


}
