package cn.com.git.msf.starters.auth.stateless;

import cn.com.git.msf.starters.auth.stateless.realm.AuthRealm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by serj on 2016/2/22.
 */
@Configuration
@EnableConfigurationProperties(AuthStatelessProperties.class)
public class AuthStatelessAutoConfig {
    @Autowired
    private AuthStatelessProperties properties;

    @Bean(name = "authRealm")
    @ConditionalOnMissingBean
    public AuthRealm realm() {
        Class<?> realmClass = properties.getRealm();
        return (AuthRealm) BeanUtils.instantiate(realmClass);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(AuthRealm authRealm) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        AuthStatelessFilter authStatelessFilter = new AuthStatelessFilter();
        authStatelessFilter.setAppid(properties.getAppid());
        authStatelessFilter.setSign(properties.getSign());
        authStatelessFilter.setAuthRealm(authRealm);
        registrationBean.setFilter(authStatelessFilter);
        return registrationBean;
    }
}
