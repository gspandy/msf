# The msf sample dubbo module #
这个模块是msf框架实现集成`schedule`功能的例子


## 使用说明 ##

Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-schedule-starter</artifactId>
            </dependency>


## 定时任务示例 ##

            @Component
            public class TaskDemo {

                private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

                @Scheduled(fixedRate = 5000) //每五秒执行一次
                public void reportCurrentTime() {
                    System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
                }

                @Scheduled(cron = "0 22 11 ? * *"  ) //每天上午11点22执行
                @DistributedLock(period=PERIOD.DAY) //支持分布式锁
                public void fixTimeExecution() {
                    System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
                }

            }

## 配置文件 ##

            #schedule options
            msf.schedule.poolSize = 10
            msf.schedule.corePoolSize = 5
            msf.schedule.maxPoolSize = 10
            msf.schedule.queueCapacity = 25