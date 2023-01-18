package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeckillSkuVo {
    private Long promotionId;
    private Long promotionSessionId;
    private Long skuId;
    private BigDecimal seckillPrice;
    private Integer seckillCount;
    private Integer seckillLimit;
    private Integer seckillSort;

    private Long startTime;
    private Long endTime;
    private String randomCode;
}
