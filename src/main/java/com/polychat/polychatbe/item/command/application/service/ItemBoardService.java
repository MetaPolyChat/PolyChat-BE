package com.polychat.polychatbe.item.command.application.service;

import com.polychat.polychatbe.item.command.domain.aggregate.Item;
import com.polychat.polychatbe.item.command.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemBoardService {

    private ItemRepository itemRepository;

    public ItemBoardService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void addItem(Item item, String itemImagePath, String itemImageUrl){
        item.setItemImageUrl(itemImageUrl);
        itemRepository.save(item);
    }

    @Transactional
    public void deleteItem(long itemId){
        itemRepository.deleteById(itemId);
    }
}
