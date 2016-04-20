package cn.com.git.msf.starters.schedule.annotation;

import cn.com.git.msf.starters.schedule.enums.PERIOD;

import java.lang.annotation.*;

/**
 * @author serj
 * @version [版本号, 2016/4/20]
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {
    PERIOD period() default PERIOD.DAY;

    boolean isOverRelease() default false;// task is over,release lock
}
