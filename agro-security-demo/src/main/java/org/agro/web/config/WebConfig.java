package org.agro.web.config;

import java.util.List;
import java.util.ArrayList;

import org.agro.web.filter.TimerFilter;
import org.agro.web.interceptor.TimerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private TimerInterceptor timeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
		super.addInterceptors(registry);
	}

	@Bean
	public FilterRegistrationBean timerFilterRegistration() {
		FilterRegistrationBean fr = new FilterRegistrationBean();
		
		TimerFilter timer = new TimerFilter();
		
		fr.setFilter(timer);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		
		fr.setUrlPatterns(urls);
		
		return fr;
	}
	
}
