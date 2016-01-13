package cn.com.git.msf.samples.dubbo.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by serj on 2016/1/12.
 */
@SpringBootApplication
public class DubboServerApplication {

    public static void main(String[] args){
        try {
            new SpringApplicationBuilder(DubboServerApplication.class).run(args);
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
