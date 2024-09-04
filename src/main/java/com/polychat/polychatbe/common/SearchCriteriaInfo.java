package com.polychat.polychatbe.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SearchCriteriaInfo {
    private String searchCriteria;
    private String searchValue;
    private Integer offset;
    private Integer limit;
    private List<String> filter;
    private String orderCriteria;
    private OrderMethod orderMethod;

}
