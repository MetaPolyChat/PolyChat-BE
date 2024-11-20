package com.polychat.polychatbe.matchingHistory.command.application.dto;


import com.polychat.polychatbe.common.PolyTime;
import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchingHistoryMapper {
    MatchingHistoryMapper INSTANCE = Mappers.getMapper(MatchingHistoryMapper.class);

    @Mapping(target = "createdAt", expression = "java(convertCreatedAtToString(entity.getCreatedAt()))")
    List<MatchingHistoryDTO> toDtoList(List<MatchingHistory> entity);

    @Mapping(target = "createdAt", expression = "java(convertCreatedAtToString(entity.getCreatedAt()))")
    MatchingHistoryDTO toDto(MatchingHistory entity);

    MatchingHistory createToEntity(CreateMatchingHistoryDTO createDto);


    @Mapping(target = "createdAt", expression = "java(convertCreatedAtToString(entity.getCreatedAt()))")
    List<ReadMatchingHistoryDTO> entityToDto(List<MatchingHistory> entity);


    default String convertCreatedAtToString(LocalDateTime entityTime) {
        return entityTime == null ? null : PolyTime.PolyTimeConverter.convToStandardTime(entityTime); // PolyTime의 변환 메서드 호출
    }
}
