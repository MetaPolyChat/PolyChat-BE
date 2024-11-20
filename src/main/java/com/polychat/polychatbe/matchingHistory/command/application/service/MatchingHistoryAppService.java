package com.polychat.polychatbe.matchingHistory.command.application.service;

import com.polychat.polychatbe.matchingHistory.command.application.dto.CreateMatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.dto.MatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.dto.MatchingHistoryMapper;
import com.polychat.polychatbe.matchingHistory.command.application.dto.ReadMatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import com.polychat.polychatbe.matchingHistory.command.domain.service.MatchingHistoryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchingHistoryAppService {

    private final MatchingHistoryDomainService domainService;
    private final MatchingHistoryMapper mapper;


    public List<MatchingHistoryDTO> findAllHistory(){
        List<MatchingHistory> allEntity = domainService.findAllMatchingHistory();
        return mapper.toDtoList(allEntity);
    }

    //create
    public MatchingHistoryDTO createNewMatchingHistory(CreateMatchingHistoryDTO createDto) {
        MatchingHistory entity = mapper.createToEntity(createDto);
        entity = domainService.createNewMatchingHistory(entity);
        return mapper.toDto(entity);
    }

    //read
    public List<ReadMatchingHistoryDTO> findMatchingHistory(Long userId) {
        List<MatchingHistory> entities= domainService.findMatchingHistory(userId);
        return mapper.entityToDto(entities);
    }

    //delete
    public void deleteMatchingHistory(Long matchingId) {
        domainService.deleteMatchingHistory(matchingId);
    }

}
