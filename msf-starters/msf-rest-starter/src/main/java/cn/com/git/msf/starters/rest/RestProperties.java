package cn.com.git.msf.starters.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author serj
 * @version [版本号, 2016/7/13]
 */
@Configuration
@ConfigurationProperties(prefix = "msf.restTemplate")
public class RestProperties {

    private int connectTimeout = 5000;
    private int readTimeout = 10000;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
