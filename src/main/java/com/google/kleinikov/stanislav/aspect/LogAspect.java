package com.google.kleinikov.stanislav.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger log = LogManager.getLogger("service");

	@Before("execution(* com.google.kleinikov.stanislav.service.impl.*.getNews(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.log(Level.INFO, joinPoint.getSignature().getName());
	}

	@Pointcut("@annotation(com.google.kleinikov.stanislav.annotation.Loggable)")
	public void annotationLog() {
	}

	@After("annotationLog()")
	public void log() {
	}

}
