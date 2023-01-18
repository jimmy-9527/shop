package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.SkuImagesEntity;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class SkuItemVo {
    private SkuInfoEntity info;
    private boolean hasStock = true;
    private List<SkuImagesEntity> images;
    private List<SkuItemSaleAttrVo> saleAttr;
    private SpuInfoDescEntity desc;
    private List<SpuItemAttrGroupVo> groupAttrs;
    private SeckillSkuVo seckillSkuVo;
}
