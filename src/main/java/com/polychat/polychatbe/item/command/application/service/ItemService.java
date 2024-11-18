package com.polychat.polychatbe.item.command.application.service;

import com.polychat.polychatbe.item.command.application.dto.ItemAddRequest;
import com.polychat.polychatbe.item.command.domain.aggregate.Item;
import com.polychat.polychatbe.item.command.domain.repository.ItemRepository;
import com.polychat.polychatbe.item.command.domain.service.ItemFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class ItemService {

    private final ItemBoardService itemBoardService;
    private ItemRepository itemRepository;
    private ItemFileUploadService itemFileUploadService;

    public ItemService(ItemBoardService itemBoardService, ItemRepository itemRepository, ItemFileUploadService itemFileUploadService) {
        this.itemBoardService = itemBoardService;
        this.itemRepository = itemRepository;
        this.itemFileUploadService = itemFileUploadService;
    }

    public void addItem(ItemAddRequest itemAddRequest) {
        Item item = ItemAddRequest.toItem(itemAddRequest);
        String imageUrl=null;
        if (itemAddRequest.getItemImage()==null){
            log.warn("there is no image to make item");
        } else{
            imageUrl = itemFileUploadService.uploadImage(
                    itemAddRequest.getItemImage()
            );
        }
        itemBoardService.addItem(item, null, imageUrl);
    }

    @Transactional
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
            String itemImageUrl = itemFileUploadService.uploadImage(
                    itemAddRequest.getItemImage()
            );
            item.setItemImageUrl(itemImageUrl);
        }

    }

    public void deleteItem(long itemId) {
        String fileUrl = itemRepository.findById(itemId)
                        .orElseThrow(()->new NoSuchElementException("해당 아이템을 찾을 수 없습니다"))
                                .getItemImageUrl();

        itemFileUploadService.deleteImage(fileUrl);
        
        // 파일 업로드나 삭제 부분은 트랜잭션에 포함되지 않게 함
        itemBoardService.deleteItem(itemId);
    }

}
