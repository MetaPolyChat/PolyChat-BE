package com.polychat.polychatbe.item.command.application.dto;

import com.polychat.polychatbe.item.command.domain.aggregate.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemAddRequest {

    @NotBlank
    private String itemName;
    @NotBlank
    private String itemDescription;

    private MultipartFile itemImage;
    private String itemType;

    @PositiveOrZero
    private int price;


    public static Item toItem(ItemAddRequest itemAddRequest){

        return new Item(
                itemAddRequest.getItemName(),
                itemAddRequest.getItemDescription(),
                itemAddRequest.getItemType(),
                itemAddRequest.getPrice(),
                LocalDateTime.now()
        );
    }
}
