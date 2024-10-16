package com.polychat.polychatbe.item.domain.aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private String itemName;
    private String itemDescription;
    private String itemImageUrl;
    private String itemType;
    private String price;

    public Item(String itemName, String itemDescription, String itemImageUrl, String itemType, String price) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImageUrl = itemImageUrl;
        this.itemType = itemType;
        this.price = price;
    }

    public void updateItem(String itemName, String itemDescription, String itemImageUrl,
                           String itemType, String price) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImageUrl = itemImageUrl;
        this.itemType = itemType;
        this.price = price;
    }


}
