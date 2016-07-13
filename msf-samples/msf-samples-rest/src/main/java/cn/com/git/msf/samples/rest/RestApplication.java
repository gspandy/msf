package cn.com.git.msf.samples.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 * @author serj
 * @version [版本号, 2016/7/13]
 */
@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext ctx = new SpringApplicationBuilder(RestApplication.class).run(args);
            RestTemplate restTemplate = (RestTemplate) ctx.getBean("restTemplate");
            System.out.println(restTemplate);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
