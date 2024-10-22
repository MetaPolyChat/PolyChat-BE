package com.polychat.polychatbe.item.command.application.controller;

import com.polychat.polychatbe.item.command.application.dto.ItemAddRequest;
import com.polychat.polychatbe.item.command.application.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "아이템 API", description = "아이템을 변경하기 위한 API")
@RestController
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "아이템 등록", description = "새로운 아이템을 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("item")
    public void addItem(@Valid @RequestBody ItemAddRequest itemAddInfo) {
        itemService.addItem(itemAddInfo);
    }

    @Operation(summary = "아이템 수정", description = "지정한 아이템의 정보를 수정합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("item/{id}")
    public void updateItem(@Valid @RequestBody ItemAddRequest itemAddInfo, @PathVariable long id) {
        itemService.modifyItem(itemAddInfo, id);
    }

    @Operation(summary = "아이템 삭제", description = "지정한 아이템을 삭제합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("item/{id}")
    public void deleteItem(@PathVariable long id){
        itemService.removeItem(id);
    }

}
