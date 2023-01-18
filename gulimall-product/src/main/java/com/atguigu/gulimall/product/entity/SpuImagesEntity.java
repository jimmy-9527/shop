package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

@Data
@TableName("pms_spu_images")
public class SpuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	private Long spuId;
	private String imgName;
	private String imgUrl;
	private Integer imgSort;
	private Integer defaultImg;
}
