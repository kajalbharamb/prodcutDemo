package com.example.ProductDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {
   @Before(value = "execution(* com.example.ProductDemo.controller.ProductController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("request at method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* com.example.ProductDemo.controller.ProductController.*(..))")
    public void AfterAdvice(JoinPoint joinPoint) {
        System.out.println("request at method:" + joinPoint.getSignature());
    }
}
