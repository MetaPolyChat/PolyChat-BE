package com.polychat.polychatbe.item.command.application.service;

import com.polychat.polychatbe.item.command.application.dto.ItemAddRequest;
import com.polychat.polychatbe.item.command.domain.aggregate.Item;
import com.polychat.polychatbe.item.command.domain.repository.ItemRepository;
import com.polychat.polychatbe.item.command.domain.service.ItemFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ItemService {

    private ItemRepository itemRepository;
    private ItemFileUploadService itemFileUploadService;

    public ItemService(ItemRepository itemRepository, ItemFileUploadService itemFileUploadService) {
        this.itemRepository = itemRepository;
        this.itemFileUploadService = itemFileUploadService;
    }

    @Transactional
    public void setItemImage(Item item, MultipartFile image) {
        String uploadedUrl=null;
        try{
            uploadedUrl = itemFileUploadService.uploadImage(image);
        } catch (Exception e) {
            log.warn("Fail to upload Image, itemId: {}", item.getItemId());
        }

        if(uploadedUrl!=null){
            item.setItemImageUrl(uploadedUrl);
            log.info("Successfully save Image, itemId: {}", item.getItemId());
        }
    }

    @Transactional
    public void addItem(ItemAddRequest itemAddRequest) {
        Item item = ItemAddRequest.toItem(itemAddRequest);
        if (itemAddRequest.getItemImage()!=null){
            setItemImage(item, itemAddRequest.getItemImage());
        }
        itemRepository.save(item);
    }

    public void modifyItem(ItemAddRequest itemAddRequest, long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()-> new RuntimeException("해당하는 아이템을 찾을 수 없습니다"));

        item.update(
                itemAddRequest.getItemName(),
                itemAddRequest.getItemDescription(),
                itemAddRequest.getItemType(),
                itemAddRequest.getPrice()
        );

        if (itemAddRequest.getItemImage()!=null){
            setItemImage(item, itemAddRequest.getItemImage());
        }

    }

    @Transactional
    public void removeItem(long itemId) {
        itemRepository.deleteById(itemId);
    }

}
