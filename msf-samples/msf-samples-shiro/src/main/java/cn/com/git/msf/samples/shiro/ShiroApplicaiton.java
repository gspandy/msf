package cn.com.git.msf.samples.shiro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by serj on 2016/1/20.
 */
@SpringBootApplication
public class ShiroApplicaiton {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(ShiroApplicaiton.class).run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
