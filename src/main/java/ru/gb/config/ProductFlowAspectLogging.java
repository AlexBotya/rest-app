package ru.gb.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductFlowAspectLogging {
    @Pointcut("execution(* ru.gb.web.product.controller.ProductController.deleteById())")
    public void doLog() {
        System.out.println("Deleting product.");
    }

    @Before("doLog()")
    public void doLogBeforeProductFlowOperation(JoinPoint joinPoint) {
        System.out.println(joinPoint);
        System.out.println("Product Operation performed successfully.");
    }

    @AfterThrowing("doLog()")
    public void catchExceptionOfProductFlowOperation(JoinPoint joinPoint) {
        System.out.println("Error!");
    }

}
