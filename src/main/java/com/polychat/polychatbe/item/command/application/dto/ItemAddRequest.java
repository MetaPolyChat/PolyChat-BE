package com.polychat.polychatbe.item.command.application.dto;

import com.polychat.polychatbe.item.command.domain.aggregate.Item;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemAddRequest {

    private String itemName;
    private String itemDescription;

    private MultipartFile itemImage;
    private String itemType;
    private String price;


    public static Item toItem(ItemAddRequest itemAddRequest){

        return new Item(
                itemAddRequest.getItemName(),
                itemAddRequest.getItemDescription(),
                itemAddRequest.getItemType(),
                itemAddRequest.getPrice()
        );
    }
}
