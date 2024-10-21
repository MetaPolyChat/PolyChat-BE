package com.polychat.polychatbe.item.command.domain.service;

import org.springframework.stereotype.Service;

@Service
public class ItemImageService {

    private ItemFileUploadService fileUploadService;

    public ItemImageService(ItemFileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }


}
