package cn.com.git.msf.starters.auth.stateless.realm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by serj on 2016/2/23.
 */
public class DefaultAuthRealm implements AuthRealm {
    public static ConcurrentHashMap<String, String> appInfos = new ConcurrentHashMap<String, String>();

    public DefaultAuthRealm() {
    }

    @Override
    public String getAppSecretkey(String appId) throws Exception {
        return appInfos.get(appId);
    }
}
