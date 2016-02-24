package cn.com.git.msf.starters.auth.stateless;

import cn.com.git.msf.starters.auth.stateless.realm.AuthRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by serj on 2016/2/22.
 */

public class AuthStatelessFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(AuthStatelessFilter.class);

    private String appid;
    private String sign;
    private AuthRealm authRealm;


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

    public AuthRealm getAuthRealm() {
        return authRealm;
    }

    public void setAuthRealm(AuthRealm authRealm) {
        this.authRealm = authRealm;
    }

    public AuthStatelessFilter() {
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            Map<String, String[]> params = request.getParameterMap();
            String appid = request.getHeader(getAppid());
            if (StringUtils.isEmpty(appid)) throw new Exception("request header's auth appid is empty!");
            String sign = request.getHeader(getSign());
            if (StringUtils.isEmpty(sign)) throw new Exception("request header's auth sign is empty!");
            String secretKey = authRealm.getAppSecretkey(appid);
            if (StringUtils.isEmpty(secretKey)) throw new Exception("app's secretKey is empty, appid = " + appid);
            if (sign.equals(HMACUtils.digest(secretKey, params))) {//签名一致
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                throw new Exception("digest sign is error!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            onAuthFail(servletResponse, e.getMessage());
        }
    }

    //认证失败时默认返回401 状态码
    private void onAuthFail(ServletResponse response, String message) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("auth error : " + message);
    }

    @Override
    public void destroy() {

    }
}
