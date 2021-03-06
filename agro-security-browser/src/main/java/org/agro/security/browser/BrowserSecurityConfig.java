/**
 * 
 */
package org.agro.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gaoxiang
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.formLogin()
				 .loginPage("/signIn.html")
				 .loginProcessingUrl("/authentication/form")
				 .and()
				 .authorizeRequests()
				 .antMatchers("/signIn.html").permitAll()
				 .anyRequest()
				 .authenticated()
				 .and()
				 .csrf().disable();
	}
}
