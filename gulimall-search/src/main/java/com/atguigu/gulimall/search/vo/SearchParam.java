package com.atguigu.gulimall.search.vo;

import lombok.Data;
import java.util.List;

@Data
public class SearchParam {
    private String keyword;
    private List<Long> brandId;
    private Long catalog3Id;
    private String sort;
    private Integer hasStock;
    private String skuPrice;
    private List<String> attrs;
    private Integer pageNum = 1;
    private String _queryString;
}
