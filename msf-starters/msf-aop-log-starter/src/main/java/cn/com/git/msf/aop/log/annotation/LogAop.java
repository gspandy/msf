package cn.com.git.msf.aop.log.annotation;

import org.springframework.boot.logging.LogLevel;

import java.lang.annotation.*;

/**
 * @author serj
 * @version [版本号, 2016/7/18]
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAop {
    LogLevel logLevel() default LogLevel.DEBUG;
}