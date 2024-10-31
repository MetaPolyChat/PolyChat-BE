package com.polychat.polychatbe.common;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.util.ParsingUtils;

import java.util.List;

@Data
public class SearchCriteriaInfo {
    private final String searchCriteria;
    private final String searchValue;
    private final List<String> filter;
    private final String orderCriteria;
    private final OrderMethod orderMethod;

    @Positive(message = "페이지 번호는 0보다 커야 합니다.")
    private final Integer pageNum;
    @Positive(message = "표시할 갯수는 0보다 커야 합니다.")
    private final Integer limit;
    private final Integer offset;

    private final String orderCriteriaSnakeCase;
    private final String searchCriteriaSnakeCase;

    public String convertCriteriaCamel(String criteria){
        return ParsingUtils.reconcatenateCamelCase(criteria, "_");
    }

    public SearchCriteriaInfo(String searchCriteria, String searchValue, List<String> filter,
                              String orderCriteria, OrderMethod orderMethod,
                              Integer pageNum, Integer limit) {
        this.searchCriteria = searchCriteria;
        this.searchCriteriaSnakeCase = searchCriteria!=null? convertCriteriaCamel(searchCriteria): null;
        this.searchValue = searchValue;
        this.filter = filter;
        this.orderCriteria = orderCriteria;
        this.orderCriteriaSnakeCase = orderCriteria!=null? convertCriteriaCamel(orderCriteria): null;
        this.orderMethod = orderMethod;

        this.pageNum = pageNum != null ? pageNum : 1;
        this.limit = limit != null ? limit : 3;

        this.offset = (this.pageNum - 1) * this.limit;
//        if(this.pageNum !=null && this.limit !=null) {
//            this.offset = (this.pageNum-1) * this.limit;
//        } else {
//            this.offset=null;
//        }
    }

}
