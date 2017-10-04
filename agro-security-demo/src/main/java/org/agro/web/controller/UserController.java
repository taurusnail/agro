/**
 * 
 */
package org.agro.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.agro.dto.User;
import org.agro.dto.UserQueryCondition;
import org.agro.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author gaoxiang
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation("用户列表查询")
	public List<User> query (UserQueryCondition condition, @PageableDefault(page=1, size=20, sort="username,asc") Pageable pageable) {
		
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		
		List<User> users = new ArrayList<>();
		users.add(new User("agro"));
		users.add(new User("zhangsan"));
		users.add(new User("lisi"));
		return users;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailVIew.class)
	public User getInfo(@PathVariable String id) {
		
//		throw new UserNotExistException(id);
		
		System.out.println("进入getInfo服务");
		
		return new User("tom");
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@ApiParam("用户ID") @PathVariable String id) {
		System.out.println(id);
	}

}
