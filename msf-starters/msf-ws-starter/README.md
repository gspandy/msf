# The ws starter module of msf project #
这个模块是msf框架快速启动WebService功能

## 使用说明 ##

1. Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-ws-starter</artifactId>
            </dependency>

2. 配置属性文件 application.properties

            #webservice options
            msf.ws.server.baseAddress = http://localhost:9090/ws/

## 示例 ##

见 `msf-samples-ws` 模块