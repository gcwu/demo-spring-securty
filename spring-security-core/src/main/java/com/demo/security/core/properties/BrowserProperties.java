package com.demo.security.core.properties;

import com.demo.security.core.constants.SecurityConstants;

public class BrowserProperties {
	/**
	 * 默认登录页
	 */
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

	public String getLoginPage() {
		return loginPage;
	}
}
