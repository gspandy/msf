package cn.com.git.msf.samples.auth.stateless;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by serj on 2016/1/20.
 */
@SpringBootApplication
public class AuthStatelessApplicaiton {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(AuthStatelessApplicaiton.class).run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
