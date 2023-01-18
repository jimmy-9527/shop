package com.atguigu.gulimall.seckill.service;

import com.atguigu.gulimall.seckill.to.SeckillSkuRedisTo;

import java.util.List;

public interface SeckillService {
    void uploadSeckillSkuLatest3Days();

    List<SeckillSkuRedisTo> getCurrentSeckillSkus();

    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    SeckillSkuRedisTo getSkuSeckilInfo(Long skuId);

    String kill(String killId, String key, Integer num) throws InterruptedException;
}
