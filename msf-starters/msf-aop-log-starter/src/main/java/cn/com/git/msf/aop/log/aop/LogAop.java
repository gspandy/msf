package cn.com.git.msf.aop.log.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author serj
 * @version [版本号, 2016/7/18]
 */
@Aspect
@Component
public class LogAop {
    private static Logger logger = LoggerFactory.getLogger(LogAop.class);

    private final static String SCAN_PACKAGE = "cn.com.git";

    @Around("execution(* " + SCAN_PACKAGE + "..*.* (..)) && " +
            "(@annotation(cn.com.git.msf.aop.log.annotation.Log)||" +
            "@target(cn.com.git.msf.aop.log.annotation.Log))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] in = joinPoint.getArgs();
        Object out = null;
        String target = joinPoint.getSignature().toLongString();
        long startTime = System.currentTimeMillis();
        try {
            out = joinPoint.proceed(in);
            if (logger.isDebugEnabled())
                logger.debug("\ntarget : {}\nin     : {}\nout    : {}\ntake   : {}ms",
                        target, JSON.toJSONString(in), JSON.toJSONString(out),
                        System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            logger.error("\ntarget : {}\nin     : {}\nout    : {}\ntake   : {}ms"
                            + (e.getCause() == null ? "\nerror  : {}" : ""),
                    target, JSON.toJSONString(in), JSON.toJSONString(out),
                    System.currentTimeMillis() - startTime, (e.getCause() == null ? e.getMessage() : e));
            throw e;
        }

    }
}
