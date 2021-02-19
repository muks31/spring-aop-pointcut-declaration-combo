package com.mukscode.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
	
	@Pointcut("execution(* com.mukscode.aop.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	//create point cut for getter method
	@Pointcut("execution(* com.mukscode.aop.dao.*.get*(..))")
	private void getter() {}
	
	//create point cut for setter method
	@Pointcut("execution(* com.mukscode.aop.dao.*.set*(..))")
	private void setter() {}
	
	//create point cut: include package/ exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoSetterGetter() {}
	
	@Before("forDaoPackageNoSetterGetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoSetterGetter()")
	public void performAPIAnalytics() {
		System.out.println("\n=======> Performing API Analytics");
	}

}
