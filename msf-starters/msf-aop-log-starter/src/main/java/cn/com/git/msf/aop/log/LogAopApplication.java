package cn.com.git.msf.aop.log;

import cn.com.git.msf.aop.log.service.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author serj
 * @version [版本号, 2016/7/18]
 */
@SpringBootApplication
public class LogAopApplication {
    private static Logger logger = LoggerFactory.getLogger(LogAopApplication.class);

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext ctx = new SpringApplicationBuilder(LogAopApplication.class).run(args);
            ((Test) ctx.getBean("test")).print();
            ((Test) ctx.getBean("test")).print1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
