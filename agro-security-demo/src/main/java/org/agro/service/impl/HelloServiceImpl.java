/**
 * 
 */
package org.agro.service.impl;

import org.agro.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiang
 *
 */
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String greeting(String name) {
		return "hello " + name;
	}

}
