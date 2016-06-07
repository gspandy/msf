package cn.com.git.msf.starters.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;

/**
 * Created by serj on 2016/1/20.
 */

@ConfigurationProperties(locations = "classpath:shiro.yaml", prefix = "msf.shiro")
public class ShiroProperties {
    /**
     * Custom Realm
     */
    private Class<?> realm;
    /**
     * URL of login
     */
    private String loginUrl;
    /**
     * URL of success
     */
    private String successUrl;
    /**
     * URL of unauthorized
     */
    private String unauthorizedUrl;
    /**
     * filter chain
     */
    private LinkedHashMap<String, String> filterChainDefinitions;


    public Class<?> getRealm() {
        return realm;
    }

    public void setRealm(Class<?> realm) {
        this.realm = realm;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    public LinkedHashMap<String, String> getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(LinkedHashMap<String, String> filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
