/**
 * 
 */
package org.agro.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author gaoxiang
 *
 */
public class UserQueryCondition {
	
	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("年龄（年龄起始值）")
	private int age;
	
	@ApiModelProperty("年龄（年龄结束值）")
	private int ageTo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	
}
