package cn.com.git.msf.samples.dubbo.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by serj on 2016/1/12.
 */
@Configuration
@ImportResource({"classpath:dubbo-consumer.xml"}) //配置dubbo client
public class DubboClientConfig {
}
