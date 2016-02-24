# The schedule starter module of msf project #
这个模块是msf框架快速启动schedule功能

## 使用说明 ##

1. Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-schedule-starter</artifactId>
            </dependency>

2. 配置属性文件 application.properties

            #schedule options
            msf.schedule.poolSize = 10
            msf.schedule.corePoolSize = 5
            msf.schedule.maxPoolSize = 10
            msf.schedule.queueCapacity = 25

## 示例 ##

见 `msf-samples-schedule` 模块