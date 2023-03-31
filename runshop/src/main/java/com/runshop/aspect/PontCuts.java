package com.runshop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PontCuts {
        @Pointcut("execution(* com.runshop.*.*.*(..))")
        public void allGetMethods() {

        }
    }

