package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberLevelDao extends BaseMapper<MemberLevelEntity> {
    MemberLevelEntity getDefaultLevel();
}
