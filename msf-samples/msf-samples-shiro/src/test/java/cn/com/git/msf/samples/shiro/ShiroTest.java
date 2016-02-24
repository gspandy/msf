package cn.com.git.msf.samples.shiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by serj on 2016/1/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShiroApplicaiton.class)
@WebIntegrationTest
public class ShiroTest {
    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl = "http://127.0.0.1:8080/";

    @Test
    public void testShiro() {
        ResponseEntity response = restTemplate.exchange(
                baseUrl.concat("login?username=zhang&password=123"),
                HttpMethod.GET,
                null,
                String.class);
        //测试登录
        assertThat(response.getBody().toString(), equalTo("login success"));
        //保持登录session
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));
        HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
        response = restTemplate.exchange(
                baseUrl.concat("index"),
                HttpMethod.GET,
                requestEntity,
                String.class);
        //测试权限页面
        assertThat(response.getBody().toString(), equalTo("index page"));

    }
}