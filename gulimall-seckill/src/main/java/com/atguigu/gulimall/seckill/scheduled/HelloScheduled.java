package com.atguigu.gulimall.seckill.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Slf4j
//@Component
//@EnableAsync
//@EnableScheduling
//public class HelloScheduled {
//     @Async
//     @Scheduled(cron = "*/5 * * ? * 4")
//     public void hello() {
//         log.info("hello...");
//         try {
//             TimeUnit.SECONDS.sleep(3);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
//}
