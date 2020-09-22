package com.hss.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAspect {

	@Pointcut("execution(public * com.hss.service.IndexService.*(..))")
	private void myPointcut() {

	}

	/**
	 * 记录HTTP请求结束时的日志
	 */
	@Before("myPointcut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {

		String class_name = joinPoint.getTarget().getClass().getName();
		String method_name = joinPoint.getSignature().getName();
		System.out.println("class_name = " + class_name);
		System.out.println("method_name = "+method_name);
	}
}
