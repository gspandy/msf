# The msf sample rest module #
这个模块是msf框架实现集成`rest template`功能的例子


## 使用说明 ##

Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-rest-starter</artifactId>
            </dependency>


## 示例 ##
            @AutoWired
            private RestTemplate restTemplate


## 配置文件 ##

            #rest template options
            msf.restTemplate.connectTimeout = 1000
            msf.restTemplate.readTimeout = 1000