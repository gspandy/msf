package cn.com.git.msf.samples.dubbo.client;

import cn.com.git.msf.samples.dubbo.service.HelloService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * Created by serj on 2016/1/12.
 */
@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args){
        ApplicationContext ctx = new SpringApplicationBuilder(DubboClientApplication.class).run(args);
        HelloService helloService = (HelloService)ctx.getBean("helloService"); // 获取远程服务代理
        String hello = helloService.sayHello("world"); // 执行远程方法
        System.out.println(hello);
    }

}
