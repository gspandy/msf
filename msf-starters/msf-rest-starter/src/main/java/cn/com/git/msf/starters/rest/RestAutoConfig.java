package cn.com.git.msf.starters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author serj
 * @version [版本号, 2016/7/13]
 */
@Configuration
@EnableConfigurationProperties(RestProperties.class)
public class RestAutoConfig {
    @Autowired
    private RestProperties properties;


    @Bean(name = "simpleClientHttpRequestFactory")
    @ConditionalOnMissingBean
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(properties.getConnectTimeout());
        simpleClientHttpRequestFactory.setReadTimeout(properties.getReadTimeout());
        return simpleClientHttpRequestFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(SimpleClientHttpRequestFactory simpleClientHttpRequestFactory) {
        return new RestTemplate(simpleClientHttpRequestFactory);
    }
}
