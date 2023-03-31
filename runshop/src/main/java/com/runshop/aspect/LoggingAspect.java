package com.runshop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.runshop.service.*.*.*(..))") //где хотим внедрить
    public void servicePointcut() {
    }

    @Before("servicePointcut()")
    public void serviceLoggerAfter(JoinPoint joinPoint) {
        String methodSignature = joinPoint.getSignature().getName();
        try {
            log.info("Service method - " + methodSignature + " - ready to start.");
        } catch (Throwable throwable) {
            log.error("Exception in method: " + methodSignature +
                    ". Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}


//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getKind());
//        System.out.println(joinPoint.getTarget());
//        for (Object arg : joinPoint.getArgs()) {
//            System.out.println(arg);
//        }

//    @Before("aroundRepositoryPointcut()")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " start");
//    }
//
//    @AfterReturning(pointcut = "aroundRepositoryPointcut()")
//    public void doAccessCheck(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " finished");
//    }