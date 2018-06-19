package com.google.kleinikov.stanislav.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger log = LogManager.getLogger("service");

	@Before("execution(* com.google.kleinikov.stanislav.service.impl.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.log(Level.INFO, joinPoint.getSignature().getName());
	}

	@Pointcut("@annotation(com.google.kleinikov.stanislav.annotation.Logable)")
	public void annotationLog() {
	}

	@AfterThrowing(pointcut = "annotationLog()", throwing = "theExc")
	public void afterThrowingServiceRemoveNewsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		log.warn("warning", theExc.toString());
	}

	@AfterThrowing(pointcut = "execution(* com.google.kleinikov.stanislav.view.ConsolMenu.*(..))", throwing = "theExc")
	public void afterThrowingMenuAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		log.warn("info", theExc);
	}
}
