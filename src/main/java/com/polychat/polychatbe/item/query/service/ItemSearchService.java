package com.polychat.polychatbe.item.query.service;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.item.query.dto.ItemDetailResponseDTO;
import com.polychat.polychatbe.item.query.dto.ItemResponseDTO;
import com.polychat.polychatbe.item.query.repository.ItemSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemSearchService {

    private ItemSearchRepository itemSearchRepository;

    public ItemSearchService(ItemSearchRepository itemSearchRepository) {
        this.itemSearchRepository = itemSearchRepository;
    }


    public ItemDetailResponseDTO findById(Long id) {
        return itemSearchRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("해당 아이템을 찾을 수 없습니다.")
        );
    }

    public List<ItemResponseDTO> findAllItem() {
        return itemSearchRepository.findAllItem();
    }

    public List<ItemResponseDTO> findItems(SearchCriteriaInfo searchCriteria){
        return itemSearchRepository.findItems(searchCriteria);
    }

    public int countAll() {
        return itemSearchRepository.countAll();
    }

}
