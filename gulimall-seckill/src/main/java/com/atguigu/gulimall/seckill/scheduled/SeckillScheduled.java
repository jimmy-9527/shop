package com.atguigu.gulimall.seckill.scheduled;

import com.atguigu.gulimall.seckill.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class SeckillScheduled {
    @Autowired
    private SeckillService seckillService;
    @Autowired
    private RedissonClient redissonClient;

    private final String upload_lock = "seckill:upload:lock";

    @Scheduled(cron = "0 0 1/1 * * ? ")
//    @Scheduled(cron = "0 * * * * ? ")
    public void uploadSeckillSkuLatest3Days() {
        log.info("上架秒杀的商品...");

        RLock lock = redissonClient.getLock(upload_lock);
        try {
            lock.lock(10, TimeUnit.SECONDS);
            seckillService.uploadSeckillSkuLatest3Days();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
