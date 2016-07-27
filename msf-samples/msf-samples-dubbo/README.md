# The msf sample dubbo module #
这个模块是msf框架实现集成`dubbo`功能的例子，其中包括服务端（provider）和客户端（consumer）


## 使用说明 ##

Maven 依赖中添加：

        <dependency>
            <groupId>cn.com.git.msf</groupId>
            <artifactId>msf-dubbo-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>javassist</groupId>
            <artifactId>javassist</artifactId>
        </dependency>


## 服务端 ##
DubboServerApplication 服务启动类（@SpringBootApplicaiton）

DubboServerConfig 服务配置类

        @Configuration
        @ImportResource({"classpath:dubbo-provider.xml"}) //配置dubbo服务
        public class DubboServerConfig {
        }

## 客户端 ##
DubboClientApplication 客户端调用启动类（@SpringBootApplicaiton）

        public static void main(String[] args){
            ApplicationContext ctx =new SpringApplicationBuilder(DubboClientApplication.class).run(args);
            HelloService helloService = (HelloService)ctx.getBean("helloService"); // 获取远程服务代理
            String hello = helloService.sayHello("world"); // 执行远程方法
            System.out.println(hello);
        }

可以直接从ApplicationContext中取，也可以在业务逻辑类中直接装载

        @AutoWired
        private HelloService helloService


DubboServerConfig 客户端配置类

        @Configuration
        @ImportResource({"classpath:dubbo-consumer.xml"}) //配置dubbo client
        public class DubboClientConfig {
        }




## 服务示例 ##
HelloService 服务接口类

HelloServiceImpl 服务实现类

        @Service
        public class HelloServiceImpl implements HelloService {
            @Override
            public String sayHello(String word) {
                return "hello ".concat(word);
            }
        }


## 配置文件 ##
application.properties, Spring Boot的配置文件，添加了 `dubbo.registry.address `参数替换dubbo配置文件中的变量。

dubbo-provider.xml dubbo服务配置文件，具体配置参考[http://dubbo.io/User+Guide-zh.htm](http://dubbo.io/User+Guide-zh.htm)

dubbo-consumer.xml dubbo客户端配置文件，具体配置参考[http://dubbo.io/User+Guide-zh.htm](http://dubbo.io/User+Guide-zh.htm)
