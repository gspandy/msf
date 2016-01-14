package cn.com.git.msf.samples.ws.service;

/**
 * Created by serj on 2016/1/14.
 */
public class Address {
    private String street;
    private String contactMan;

    public Address() {
    }

    public Address(String street, String contactMan) {
        this.street = street;
        this.contactMan = contactMan;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }
}
