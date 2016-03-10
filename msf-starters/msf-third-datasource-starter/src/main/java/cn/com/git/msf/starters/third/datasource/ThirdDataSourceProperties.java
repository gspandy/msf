package cn.com.git.msf.starters.third.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author serj
 * @version 1.0  , 2016/3/4
 */

@ConfigurationProperties(prefix = "msf.third.datasource")
public class ThirdDataSourceProperties {

    private List<String> name = new ArrayList<String>();
    private List<String> url = new ArrayList<String>();
    private List<String> username = new ArrayList<String>();
    private List<String> password = new ArrayList<String>();
    private List<String> driverClassName = new ArrayList<String>();

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public List<String> getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(List<String> driverClassName) {
        this.driverClassName = driverClassName;
    }
}
