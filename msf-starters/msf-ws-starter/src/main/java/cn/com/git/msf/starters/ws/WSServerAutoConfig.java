package cn.com.git.msf.starters.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 * Created by serj on 2016/1/14.
 */
@Configuration
@EnableConfigurationProperties(WSServerProperties.class)
public class WSServerAutoConfig {

    private final static Logger logger = LoggerFactory.getLogger(WSServerAutoConfig.class);

    @Autowired
    private WSServerProperties properties;


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "msf.ws.server", name = "baseAddress", matchIfMissing = false)
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        simpleJaxWsServiceExporter.setBaseAddress(properties.getBaseAddress());
        if (properties.getBaseAddress() == null) {
            logger.warn("Not found WebService's baseAddress!");
        }
        logger.info("WebService's baseAddress : {}...✓", properties.getBaseAddress());
        return simpleJaxWsServiceExporter;
    }

}
