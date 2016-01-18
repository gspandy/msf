package cn.com.git.msf.samples.schedule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by serj on 2016/1/18.
 */
@SpringBootApplication
public class ScheduleApplication {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(ScheduleApplication.class).run(args);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
