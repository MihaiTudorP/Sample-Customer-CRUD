/**
 * 
 */
package com.luv2code.springdemo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Logging aspect for demonstrating Spring AOP in the web app
 * @author Mihai-Tudor Popescu
 *
 */
@Aspect
@Component
public class CRMLoggingAspect {
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display the method we are calling
		displayMethod(theJoinPoint, "@Before");
		
		// display the arguments for the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display the arguments
		for (Object arg: args) {
			myLogger.info("====>> argument: " + arg);
		}
	}

	/**
	 * @param theJoinPoint
	 */
	private void displayMethod(JoinPoint theJoinPoint, String annotation) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in " + annotation + ": calling method: " + theMethod);
	}
	
	// add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method returning from
		displayMethod(theJoinPoint, "@AfterReturning");
		
		// display data returned
		if (theResult != null) {
			myLogger.info("====>> result: " + theResult);
		}
	}
}
