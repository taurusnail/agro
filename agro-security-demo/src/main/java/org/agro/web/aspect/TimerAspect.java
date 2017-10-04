/**
 * 
 */
package org.agro.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author gaoxiang
 *
 */

@Aspect
@Component
public class TimerAspect {
	
	@Around("execution(* org.agro.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("timer aspect start");
		
		for (Object arg : pjp.getArgs()) {
			System.out.println("arg:" + arg);
		}
		
		long start = new Date().getTime();
		Object object = pjp.proceed();
		System.out.println("timer aspect spend: " + (new Date().getTime() - start));
		System.out.println("timer aspect end");
		return object;
	}

}
