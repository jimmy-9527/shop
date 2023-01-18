package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private Long brandId;
	private Long catelogId;
	private String brandName;
	private String catelogName;
}
