package com.polychat.polychatbe.friendBoard.service;

import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import com.polychat.polychatbe.friendBoard.repository.friendBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class friendBoardService {
    final friendBoardRepository repository;

    @Autowired
    public friendBoardService(friendBoardRepository repository)
    {
        this.repository = repository;
    }

    public friendBoard save(friendBoard fb){
        return repository.save(fb);
    }

    public List<friendBoard> findAll(){
        return repository.findAll();
    }
}
