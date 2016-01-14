package cn.com.git.msf.samples.ws.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by serj on 2016/1/14.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.com.git.msf.samples.ws"})
public class WSServerApplication {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(WSServerApplication.class).run(args);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
