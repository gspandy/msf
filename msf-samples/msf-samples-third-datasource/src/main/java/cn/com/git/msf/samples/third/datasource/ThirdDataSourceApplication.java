package cn.com.git.msf.samples.third.datasource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author serj
 * @version 1.0  , 2016/3/4
 */
@SpringBootApplication
public class ThirdDataSourceApplication {
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new SpringApplicationBuilder(ThirdDataSourceApplication.class).run(args);
            DriverManagerDataSource ds = (DriverManagerDataSource) ctx.getBean("thirdDataSource");
            System.out.println(ds.getConnection());
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
