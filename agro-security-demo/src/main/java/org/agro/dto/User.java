/**
 * 
 */
package org.agro.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author gaoxiang
 *
 */
public class User {
	
	public interface UserSimpleView {};
	
	public interface UserDetailVIew extends UserSimpleView{};
	
	private String id;
	
	private String username;
	
	@NotBlank
	private String password;
	
	private Date birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailVIew.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public User() {
		super();
	}

}
