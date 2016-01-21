package cn.com.git.msf.samples.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serj on 2016/1/20.
 */
@RestController
public class ShiroController {

    @RequestMapping("/login")
    public String login(String username, String password) throws Exception {
        String result = "login success";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            result = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            result = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch 处理
            result = "其他错误：" + e.getMessage();
        }
        return result;
    }

    @RequestMapping("/index")
    public String index() throws Exception {
        return "index page";
    }

    @RequiresRoles("test")
    @RequestMapping("/test")
    public String test() throws Exception {
        return "test role page";
    }

    @RequestMapping("/logout")
    public String logout() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "logout success";
    }

    @RequestMapping("/403")
    public String page403() throws Exception {
        return "403 page";
    }

    @RequestMapping("/success")
    public String success() throws Exception {
        return "success page";
    }


}
