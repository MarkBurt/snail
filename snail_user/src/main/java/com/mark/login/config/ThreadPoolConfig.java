package com.mark.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description :  线程池配置
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 01:35$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 01:35$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public class ThreadPoolConfig {

    /**
     * 核心线程数（默认线程数）
     */
    private static final int corePoolSize = 10;
    /**
     * 最大线程数
     */
    private static final int maxPoolSize = 100;
    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    private static final int keepAliveTime = 10;
    /**
     * 缓冲队列数
     */
    private static final int queueCapacity = 500;
    /**
     * 线程池名前缀
     */
    private static final String threadNamePrefix = "default-async";

    /**
     * 默认异步线程池
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setThreadNamePrefix(threadNamePrefix);
        pool.setCorePoolSize(corePoolSize);
        pool.setMaxPoolSize(maxPoolSize);
        pool.setKeepAliveSeconds(keepAliveTime);
        pool.setQueueCapacity(queueCapacity);
        // 直接在execute方法的调用线程中运行
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        pool.initialize();
        return pool;
    }


}
