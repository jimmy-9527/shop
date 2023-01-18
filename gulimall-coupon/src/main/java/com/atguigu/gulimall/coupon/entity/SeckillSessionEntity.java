package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	private String name;
	private Date startTime;
	private Date endTime;
	private Integer status;
	private Date createTime;

	@TableField(exist = false)
	private List<SeckillSkuRelationEntity> relationSkus;
}
