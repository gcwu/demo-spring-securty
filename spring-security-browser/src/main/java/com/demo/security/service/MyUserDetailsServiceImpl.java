package com.demo.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//TODO这里写查找数据库的信息
		logger.info("用户信息登录用户名{}",userName);
		logger.info("用户信息登录用户密码{}",passwordEncoder.encode("123456"));
		return new User("admin", passwordEncoder.encode("123456"), AuthorityUtils.createAuthorityList("admin"));
	}

}
