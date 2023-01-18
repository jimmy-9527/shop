package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	private Long skuId;
	private String imgUrl;
	private Integer imgSort;
	private Integer defaultImg;
}
