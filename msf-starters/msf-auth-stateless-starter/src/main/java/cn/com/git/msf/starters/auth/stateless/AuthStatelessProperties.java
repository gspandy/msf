package cn.com.git.msf.starters.auth.stateless;

import cn.com.git.msf.starters.auth.stateless.realm.DefaultAuthRealm;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by serj on 2016/2/22.
 */
@ConfigurationProperties(prefix = "msf.auth.stateless")
public class AuthStatelessProperties {
    private String appid = "appid";

    private String sign = "sign";

    private Class<?> realm = DefaultAuthRealm.class;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Class<?> getRealm() {
        return realm;
    }

    public void setRealm(Class<?> realm) {
        this.realm = realm;
    }
}
