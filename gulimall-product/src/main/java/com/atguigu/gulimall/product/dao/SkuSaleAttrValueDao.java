package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atguigu.gulimall.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {
    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);
    List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);
}
