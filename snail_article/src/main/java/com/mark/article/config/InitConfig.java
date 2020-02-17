package com.mark.article.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description :  扫描配置类
 * @Author :  Markburt
 * @CreateDate :  2020/2/17$ 下午 12:06$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/17$ 下午 12:06$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Configuration
@ComponentScan({
        "com.mark.common.core",
        "com.mark.common.common.init",
        "com.mark.common.quartz",
        "com.mark.common.kafka",
        "com.mark.common.kafkastream"
                })
@EnableScheduling
public class InitConfig {
}
