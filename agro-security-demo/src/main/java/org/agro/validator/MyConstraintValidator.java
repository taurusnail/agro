/**
 * 
 */
package org.agro.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.agro.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gaoxiang
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	
	@Autowired
	private HelloService helloService;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		System.out.println(helloService.greeting((String)value));
		
		return false;
	}

}
