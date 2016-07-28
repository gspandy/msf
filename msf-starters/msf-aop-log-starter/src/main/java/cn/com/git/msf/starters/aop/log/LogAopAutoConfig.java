package cn.com.git.msf.starters.aop.log;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author serj
 * @version [版本号, 2016/7/28]
 */
@Configuration
@ConfigurationProperties(prefix = "msf.aop.log")
@ComponentScan(basePackages = {"cn.com.git.msf.starters.aop.log.aop"})
public class LogAopAutoConfig {
}
