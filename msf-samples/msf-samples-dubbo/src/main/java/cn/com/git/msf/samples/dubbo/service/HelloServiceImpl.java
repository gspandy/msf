package cn.com.git.msf.samples.dubbo.service;

import org.springframework.stereotype.Service;

/**
 * Created by serj on 2016/1/12.
 */

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String word) {
        return "hello ".concat(word);
    }
}
