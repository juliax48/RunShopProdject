package com.runshop.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Component
@Aspect
public class MyAspect {
    public class Pointcuts {
    }
    }

//        @Around("Pointcuts.allAddMethods()")
//        public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
//            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//            Book book = null;
//
//            if (methodSignature.getName().equals("addBook")) {
//                Object[] arguments = joinPoint.getArgs();
//                for (Object arg : arguments) {
//                    if (arg instanceof Book) {
//                        book = (Book) arg;
//                        log.info("Попытка добавить книгу с названием {}", book.getTitle());
//                    }
//                }
//            }
//        }
//    }
//}
