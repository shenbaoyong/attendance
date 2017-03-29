package com.shenbaoyong.attendance.timetask;

import com.shenbaoyong.attendance.cache.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Baoyong Shen on 2017/3/16.
 */
@Component
public class BizQuartz {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisCache cache;

    /**
     * 每隔5分钟定时清理缓存
     * （这里要注意集群环境 可能出现重复触发的情况 ）
     */
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void cacheClear() {
        LOG.info("@Scheduled-------cacheClear()");
        cache.clearCache();
    }

    /**
     * 每隔5分钟定时清理缓存
     * （这里要注意集群环境 可能出现重复触发的情况 ）
     */
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void setRandomCache() {
        LOG.info("@Scheduled-------setRandomCache()");

        Random random = new Random(100);
        String key = "random-key-" + random.nextInt();
        cache.putCache(key, random.nextInt());
    }

}
