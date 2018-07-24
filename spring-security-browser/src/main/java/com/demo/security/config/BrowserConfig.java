package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.security.core.properties.SecurityProperties;

@Configuration
public class BrowserConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private SecurityProperties securityProperties;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/imooc-signIn.html")
		.loginProcessingUrl("/authentication/form")
		.and()
		.authorizeRequests()
		.antMatchers("/imooc-signIn.html",
				securityProperties.getBrowser().getLoginPage()
				).permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable();
	}

}
