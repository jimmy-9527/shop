package com.atguigu.gulimall.order.to;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SpuInfoVo {
    private Long id;
    private String spuName;
    private String spuDescription;
    private Long catalogId;
    private Long brandId;
    private String brandName;
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;
    private Date createTime;
    private Date updateTime;
}
