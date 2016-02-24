package cn.com.git.msf.starters.auth.stateless.realm;

/**
 * Created by serj on 2016/2/23.
 */
public interface AuthRealm {

    public String getAppSecretkey(String appId) throws Exception;
}
