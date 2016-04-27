package cn.com.git.msf.samples.schedule.task;

import cn.com.git.msf.starters.schedule.annotation.DistributedLock;
import cn.com.git.msf.starters.schedule.enums.PERIOD;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by serj on 2016/1/18.
 */
@Component
public class TaskDemo {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) //每五秒执行一次
    @DistributedLock(period = PERIOD.MONTH, release = true)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 35 12 ? * *") //每天上午11点22执行
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }

}
