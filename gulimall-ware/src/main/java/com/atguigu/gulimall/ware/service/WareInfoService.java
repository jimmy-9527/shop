package com.atguigu.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.ware.entity.WareInfoEntity;
import com.atguigu.gulimall.ware.vo.FareVo;

import java.util.Map;

public interface WareInfoService extends IService<WareInfoEntity> {
    PageUtils queryPage(Map<String, Object> params);
    FareVo getFare(Long addrId);
}

