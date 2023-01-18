package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;


@Data
@TableName("pms_comment_replay")
public class CommentReplayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	private Long commentId;
	private Long replyId;
}
