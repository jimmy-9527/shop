package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long attrGroupId;
	private String attrGroupName;
	private Integer sort;
	private String descript;
	private String icon;
	private Long catelogId;

	@TableField(exist = false)
	private Long[] catelogPath;
}
