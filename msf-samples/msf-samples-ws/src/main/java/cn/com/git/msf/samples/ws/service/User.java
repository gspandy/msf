package cn.com.git.msf.samples.ws.service;

import java.util.List;

/**
 * Created by serj on 2016/1/14.
 */
public class User {

    private String name;
    private String password;
    private List<Address> addressList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
