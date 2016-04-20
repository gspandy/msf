package cn.com.git.msf.starters.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by serj on 2016/1/18.
 */
@Configuration
@EnableAsync
@EnableScheduling
@EnableConfigurationProperties(ScheduleProperties.class)
public class ScheduleAutoConfig {

    @Autowired
    private ScheduleProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(properties.getCorePoolSize());
        taskExecutor.setMaxPoolSize(properties.getMaxPoolSize());
        taskExecutor.setQueueCapacity(properties.getQueueCapacity());
        return taskExecutor;
    }

    @Bean
    @ConditionalOnMissingBean
    public ThreadPoolTaskScheduler taskScheduler() {
        LockThreadPoolTaskScheduler taskScheduler = new LockThreadPoolTaskScheduler();
        taskScheduler.setLockKeyPerfix(properties.getLockKeyPerfix());
        taskScheduler.setPoolSize(properties.getPoolSize());
        return taskScheduler;
    }
}
