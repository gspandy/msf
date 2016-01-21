package cn.com.git.msf.starters.ws;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by serj on 2016/1/20.
 */
@ConfigurationProperties(prefix = "msf.ws.server")
public class WSServerProperties {

    private String baseAddress;

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }
}
