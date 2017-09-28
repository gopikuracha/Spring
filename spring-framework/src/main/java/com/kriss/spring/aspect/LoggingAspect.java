package com.kriss.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("allDraws()")
	public void LoggingAdvice(JoinPoint joinPoint) {
		System.out.println("ASPECTS...... " + joinPoint.getSignature());
	}
	
	@After("allDraws()")
	public void LoggingAdviceAfter(JoinPoint joinPoint) {
		System.out.println("ASPECTS After...... " + joinPoint.getSignature());
	}
	
	@Pointcut("execution(* com.kriss.spring.DemoApp.model.Triangle.*())")
	public void allDraws(){}
}
