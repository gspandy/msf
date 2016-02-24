package cn.com.git.msf.samples.auth.stateless;


import cn.com.git.msf.starters.auth.stateless.realm.AuthRealm;

/**
 * Created by serj on 2016/1/20.
 */
public class MyAuthStatelessRealm implements AuthRealm {
    @Override
    public String getAppSecretkey(String appId) throws Exception {
        return null;
    }
}
