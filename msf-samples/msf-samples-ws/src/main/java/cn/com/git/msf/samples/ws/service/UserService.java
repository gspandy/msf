package cn.com.git.msf.samples.ws.service;

import java.util.List;

/**
 * Created by serj on 2016/1/14.
 */
public interface UserService {
    User findUser(String name);

    void addUser(String name, String password, List<Address> addressList);
}
