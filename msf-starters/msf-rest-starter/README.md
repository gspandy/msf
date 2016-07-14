# The rest starter module of msf project #
这个模块是msf框架快速启动rest template功能

## 使用说明 ##

1. Maven 依赖中添加：

                    <dependency>
                        <groupId>cn.com.git.msf</groupId>
                        <artifactId>msf-rest-starter</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-web</artifactId>
                    </dependency>

2. 配置属性文件 application.properties

            #rest template options
            msf.restTemplate.connectTimeout = 1000
            msf.restTemplate.readTimeout = 1000

## 示例 ##

见 `msf-samples-rest` 模块