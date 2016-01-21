package cn.com.git.msf.starters.schedule;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by serj on 2016/1/20.
 */
@ConfigurationProperties(prefix = "msf.schedule")
public class ScheduleProperties {
    private int corePoolSize = 5;

    private int maxPoolSize = 10;

    private int queueCapacity = 25;

    private int poolSize = 10;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

}
