package com.polychat.polychatbe.item.query.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO
{
    private long itemId;
    private String itemName;
    private String itemType;
    private String price;
}
