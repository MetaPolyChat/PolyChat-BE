package com.polychat.polychatbe.blockList.command.application.controller;

import com.polychat.polychatbe.blockList.command.application.service.BlockListAppService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockListController {

    BlockListAppService blockListAppService;

    public BlockListController(BlockListAppService blockListAppService) {
        this.blockListAppService = blockListAppService;
    }


}
