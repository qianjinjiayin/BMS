package com.digital.service;

import javax.servlet.http.HttpSession;

import com.digital.data.UserData;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public interface SessionService
{
	String CURRENT_USER = "currentUser";

	HttpSession getSession();

	void saveUser(final UserData user);

	UserData getCurrentUser();

	void cleanUserInformation();
}
