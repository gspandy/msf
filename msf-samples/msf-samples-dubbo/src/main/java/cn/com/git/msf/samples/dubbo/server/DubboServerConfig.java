package cn.com.git.msf.samples.dubbo.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by serj on 2016/1/12.
 */
@Configuration
@ImportResource({"classpath:dubbo-provider.xml"}) //配置dubbo服务
public class DubboServerConfig {
}
