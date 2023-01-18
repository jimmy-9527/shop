package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	private String spuName;
	private String spuDescription;
	private Long catalogId;
	private Long brandId;

	@TableField(exist = false)
	private String brandName;

	private BigDecimal weight;
	private Integer publishStatus;
	private Date createTime;
	private Date updateTime;
}
