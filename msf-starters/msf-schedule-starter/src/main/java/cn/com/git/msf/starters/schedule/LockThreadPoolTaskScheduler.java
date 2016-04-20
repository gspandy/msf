package cn.com.git.msf.starters.schedule;

import cn.com.git.msf.starters.schedule.annotation.DistributedLock;
import cn.com.git.msf.starters.schedule.enums.PERIOD;
import cn.com.git.msf.starters.schedule.enums.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import redis.clients.jedis.JedisCluster;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @author serj
 * @version [版本号, 2016/4/20]
 */
public class LockThreadPoolTaskScheduler extends ThreadPoolTaskScheduler {
    private String lockKeyPerfix;

    @Autowired
    private JedisCluster jedisCluster;

    public String getLockKeyPerfix() {
        return lockKeyPerfix;
    }

    public void setLockKeyPerfix(String lockKeyPerfix) {
        this.lockKeyPerfix = lockKeyPerfix;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        return super.scheduleAtFixedRate(taskWrapper(task, lockKeyPerfix), period);
    }

    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        return super.schedule(taskWrapper(task, lockKeyPerfix), trigger);
    }

    public ScheduledFuture<?> schedule(Runnable task, Date startTime) {
        return super.schedule(taskWrapper(task, lockKeyPerfix), startTime);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        return super.scheduleAtFixedRate(taskWrapper(task, lockKeyPerfix), startTime, period);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, Date startTime, long delay) {
        return super.scheduleWithFixedDelay(taskWrapper(task, lockKeyPerfix), startTime, delay);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, long delay) {
        return super.scheduleWithFixedDelay(taskWrapper(task, lockKeyPerfix), delay);
    }

    private Runnable taskWrapper(final Runnable task, final String lockKeyPerfix) {
        return new Runnable() {
            public void run() {
                ScheduledMethodRunnable scheduledMethodRunnable = (ScheduledMethodRunnable) task;
                Method targetMethod = scheduledMethodRunnable.getMethod();
                DistributedLock distrbutedLock = targetMethod.getAnnotation(DistributedLock.class);
                if (distrbutedLock == null) {//没有 DistributedLock 注解
                    task.run();
                } else {
                    if (distrbutedLock.isOverRelease()) {//释放锁,按周期-1
                        String previousKey = lockKeyPerfix.concat(":")
                                .concat(scheduledMethodRunnable.getClass().getSimpleName()).concat(":")
                                .concat(targetMethod.getName()).concat(":")
                                .concat(toDateString(distrbutedLock.period(), true));
                        jedisCluster.del(previousKey);
                    }
                    String key = lockKeyPerfix.concat(":")
                            .concat(scheduledMethodRunnable.getClass().getSimpleName()).concat(":")
                            .concat(targetMethod.getName()).concat(":")
                            .concat(toDateString(distrbutedLock.period(), false));
                    if (jedisCluster.setnx(key, STATUS.RUNNING.toString()) == 1) {//获得锁
                        task.run();
                        jedisCluster.set(key, STATUS.COMPLETED.toString());
                    }
                }
            }
        };
    }

    private static String toDateString(PERIOD period, boolean isPrevious) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Calendar calendar = Calendar.getInstance();
        if (period == PERIOD.HOUR) {
            sdf.applyPattern("yyyyMMddHH");
            if (isPrevious) calendar.add(Calendar.HOUR, -1);
        }
        if (period == PERIOD.DAY) {
            sdf.applyPattern("yyyyMMdd");
            if (isPrevious) calendar.add(Calendar.DATE, -1);
        }
        if (period == PERIOD.MONTH) {
            sdf.applyPattern("yyyyMM");
            if (isPrevious) calendar.add(Calendar.MONTH, -1);
        }
        if (period == PERIOD.YEAR) {
            sdf.applyPattern("yyyy");
            if (isPrevious) calendar.add(Calendar.YEAR, -1);
        }
        return sdf.format(calendar.getTime());
    }

}
