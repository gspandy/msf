package cn.com.git.msf.aop.log.service;

import cn.com.git.msf.aop.log.annotation.LogAop;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

/**
 * @author serj
 * @version [版本号, 2016/7/18]
 */
@Service
@LogAop(logLevel = LogLevel.INFO)
public class Test {

    public void print() {
        System.out.println("print");
    }

    public void print1() {
        System.out.println("print1");
    }
}
