package cn.com.git.msf.aop.log.aop;

import cn.com.git.msf.aop.log.annotation.LogAop;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author serj
 * @version [版本号, 2016/7/18]
 */
@Aspect
@Component
public class LogAopImpl {
    private static Logger logger = LoggerFactory.getLogger(LogAopImpl.class);

    private final static String SCAN_PACKAGE = "cn.com.git";

    @Around("execution(* " + SCAN_PACKAGE + "..*.* (..)) && " +
            "(@annotation(cn.com.git.msf.aop.log.annotation.LogAop)||" +
            "@target(cn.com.git.msf.aop.log.annotation.LogAop))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] in = joinPoint.getArgs();
        Object out = null;
        String target = joinPoint.getSignature().toLongString();
        long startTime = System.currentTimeMillis();
        try {
            out = joinPoint.proceed(in);
            String logFormatter = "\ntarget : {}\nin     : {}\nout    : {}\ntake   : {}ms";
            Object[] objs = new Object[]{target, JSON.toJSONString(in), JSON.toJSONString(out),
                    System.currentTimeMillis() - startTime};
            if (LogLevel.DEBUG == getLogAopAnnotation(joinPoint).logLevel())
                logger.debug(logFormatter, objs);
            if (LogLevel.INFO == getLogAopAnnotation(joinPoint).logLevel())
                logger.info(logFormatter, objs);
        } catch (Exception e) {
            logger.error("\ntarget : {}\nin     : {}\nout    : {}\ntake   : {}ms"
                            + (e.getCause() == null ? "\nerror  : {}" : ""),
                    target, JSON.toJSONString(in), JSON.toJSONString(out),
                    System.currentTimeMillis() - startTime, (e.getCause() == null ? e.getMessage() : e));
            throw e;
        }

    }

    public static LogAop getLogAopAnnotation(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAop logAop = method.getAnnotation(LogAop.class);
        if (logAop != null) return logAop;
        return (LogAop) joinPoint.getTarget().getClass().getAnnotation(LogAop.class);
    }
}
