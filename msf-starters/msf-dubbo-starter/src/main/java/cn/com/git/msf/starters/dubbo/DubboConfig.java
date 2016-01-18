package cn.com.git.msf.starters.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by serj on 2016/1/15.
 */
@Configuration
@ConfigurationProperties(prefix = "msf.dubbo")
public class DubboConfig {
}
