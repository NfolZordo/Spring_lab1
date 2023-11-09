package com.example.lab3.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* getName*(..))")
    public void pointcutName() {
    }

    @Pointcut("execution(* com.example.lab3.Phone.*(..))")
    public void pointcutPhone() {
    }

    @Pointcut("execution(* com.example.lab3.Product.getPrice*(..))")
    public void pointcutProductPrice() {
    }

    @Pointcut("execution(* com.example.lab3.Product.get*(..))")
    public void pointcutProduct() {
    }

    @Before("pointcutName() && !pointcutProduct()")
    public void beforeNameNotProduct() {
        System.out.println(" ***** getName metod *****");
    }

    @Before("pointcutPhone()")
    public void beforeGetPhone() {
        System.out.println(" *** getPhone metogs ***");
    }

    @Before("pointcutProductPrice() && !pointcutPhone()")
    public void logMethodCall2() {
        System.out.println(" ******** getPrice metod *******");
    }
}