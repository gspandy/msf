package cn.com.git.msf.samples.ws.server;

import cn.com.git.msf.samples.ws.service.Address;
import cn.com.git.msf.samples.ws.service.User;
import cn.com.git.msf.samples.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by serj on 2016/1/14.
 */
@Component
@WebService(serviceName = "UserService")
public class UserServiceJAXWS {
    @Autowired
    private UserService userService;

    @WebMethod
    public User findUser(@WebParam(name = "name") String name) {
        return userService.findUser(name);
    }

    @WebMethod
    public void addUser(String name, String password, List<Address> addressList) {
        userService.addUser(name, password, addressList);
    }
}
