package cn.com.git.msf.samples.ws.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serj on 2016/1/14.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUser(String name) {
        User user = new User();
        user.setName("serj");
        user.setPassword("123456");
        ArrayList<Address> addressArrayList = new ArrayList<Address>();
        addressArrayList.add(new Address("jiangsu nanking", "serj1"));
        addressArrayList.add(new Address("china shanghai", "serj2"));
        user.setAddressList(addressArrayList);
        return user;
    }

    @Override
    public void addUser(String name, String password, List<Address> addressList) {

    }
}
