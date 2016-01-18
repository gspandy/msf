package cn.com.git.msf.starters.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 * Created by serj on 2016/1/14.
 */
@Configuration
@ConfigurationProperties(prefix = "msf.ws.server")
public class WSServerAutoConfig {

    private final static Logger logger = LoggerFactory.getLogger(WSServerAutoConfig.class);

    private String baseAddress;

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        simpleJaxWsServiceExporter.setBaseAddress(baseAddress);
        if (baseAddress == null) {
            logger.warn("Not found WebService's baseAddress!");
        }
        logger.info("WebService's baseAddress : {}", baseAddress);
        return simpleJaxWsServiceExporter;
    }

}
