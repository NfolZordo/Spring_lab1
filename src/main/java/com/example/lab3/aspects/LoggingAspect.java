package com.example.lab3.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* getName*(..))")
    public void appLab3Methods() {
    }

    @Pointcut("execution(* com.example.lab3.Phone.getPrice*(..))")
    public void appLab3Methods2() {
    }

    @Pointcut("execution(* com.example.lab3.Product.getPrice*(..))")
    public void appLab3Methods3() {
    }

    @Pointcut("execution(* com.example.lab3.Product.*(..))")
    public void appLab3Methods4() {
    }

    @Before("appLab3Methods() && !appLab3Methods4()")
    public void logMethodCall() {
        System.out.println(" ****** getName Aspect ****");
    }
    @Before("appLab3Methods3() && !appLab3Methods2()")
    public void logMethodCall2() {
        System.out.println(" ****** getPrice Aspect ****");
    }
}