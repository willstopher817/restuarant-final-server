package com.mercury.final_server.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MostExecutedServiceMethodAspect {

    // cross-cutting concern: which method executes most in services?

    // advice: print method name after an method in service executed

    // Join Point: when any service method executes by our application

    @Pointcut("execution(* com.mercury.SpringBootRESTDemo.service.*Service.*(..))")
    public void getJoinPoint() {

    }

    // @Before: execute advice before method executes
    // @AfterReturning: execute after method runs successfully and return
    // @AfterThrowing : execute after method throws an exception
    // @After: execute after method executes(no matter succeed or with exception)
    // @Around: can control how the original method will be executed. you can do
    // something around the method execution
    @After("getJoinPoint()")
    public void printMethodNameAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " is executed.(AOP)");
    }
}
