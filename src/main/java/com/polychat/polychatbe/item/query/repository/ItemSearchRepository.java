package com.polychat.polychatbe.item.query.repository;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.item.query.dto.ItemDetailResponseDTO;
import com.polychat.polychatbe.item.query.dto.ItemResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemSearchRepository {

    Optional<ItemDetailResponseDTO> findById(long itemId);
    List<ItemResponseDTO> findAllItem();
    List<ItemResponseDTO> findItems(SearchCriteriaInfo searchCriteria);
    int countAll();

}
