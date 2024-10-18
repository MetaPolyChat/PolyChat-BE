package com.polychat.polychatbe.item.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailResponseDTO{
    private long itemId;
    private String itemName;
    private String itemDescription;
    private String itemImageUrl;
    private String itemType;
    private String price;
}
