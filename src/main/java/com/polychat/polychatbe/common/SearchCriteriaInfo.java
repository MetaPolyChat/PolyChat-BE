package com.polychat.polychatbe.common;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.util.ParsingUtils;

import java.util.List;

@Data
@Setter
public class SearchCriteriaInfo {
    private String searchCriteria;
    private String searchValue;
    private List<String> filter;
    private String orderCriteria;
    private OrderMethod orderMethod;
    @Positive(message = "페이지 번호는 0보다 커야 합니다.")
    private Integer pageNum;
    @Positive(message = "표시할 갯수는 0보다 커야 합니다.")
    private Integer limit;
    private Integer offset;

    private String orderCriteriaSnakeCase;
    private String searchCriteriaSnakeCase;

    public String convertCriteriaCamel(String criteria){
        return ParsingUtils.reconcatenateCamelCase(criteria, "_");
    }


    public SearchCriteriaInfo() {
        this.pageNum = 1;
        this.limit=5;
        this.offset = 0;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        this.offset = (this.pageNum - 1) * this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
        this.offset = (this.pageNum - 1) * this.limit;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
        this.searchCriteriaSnakeCase = searchCriteria!=null? convertCriteriaCamel(searchCriteria): null;
    }

    public void setOrderCriteria(String orderCriteria) {
        this.orderCriteria = orderCriteria;
        this.orderCriteriaSnakeCase = orderCriteria!=null? convertCriteriaCamel(orderCriteria): null;
    }

    public SearchCriteriaInfo(Integer limit, Integer pageNum) {
        this.pageNum = pageNum != null ? pageNum : 1;
        this.limit = limit != null ? limit : 3;

        this.offset = (this.pageNum - 1) * this.limit;
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
