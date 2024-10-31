package com.polychat.polychatbe.item.query.controller;

import com.polychat.polychatbe.common.PageItemResponse;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.common.utils.ApiUtils;
import com.polychat.polychatbe.item.query.dto.ItemDetailResponseDTO;
import com.polychat.polychatbe.item.query.dto.ItemResponseDTO;
import com.polychat.polychatbe.item.query.service.ItemSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@Tag(name = "아이템 조회 API", description = "아이템 정보를 조회하는 API")
public class ItemSearchController {

    private ItemSearchService itemSearchService;

    public ItemSearchController(ItemSearchService itemSearchService) {
        this.itemSearchService = itemSearchService;
    }

    @Operation(summary = "아이템 정보 조회", description = "지정한 아이템의 상세 정보를 조회합니다.")
    @GetMapping("item/{id}")
    public ResponseEntity<?> getItem(@PathVariable long id){

        ItemDetailResponseDTO itemDetailInfo = itemSearchService.findById(id);

        return ResponseEntity.ok().body(ApiUtils.success(itemDetailInfo));
    }

    @Operation(summary = "아이템 목록 조회", description = "아이템 목록을 페이지별로 조회합니다.")
    @GetMapping("item")
    public ResponseEntity<PageItemResponse<ItemResponseDTO>> getItemList(
            @Valid @ModelAttribute SearchCriteriaInfo searchCriteriaInfo){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(
                new PageItemResponse<>(
                        itemSearchService.countAll(),
                        itemSearchService.findItems(searchCriteriaInfo)),
                headers, HttpStatus.OK);
    }
}
