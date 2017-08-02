package com.digital.service;

import com.digital.domain.data.UserInfoData;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public interface SessionService
{
	String CURRENT_USER = "currentUser";

	void saveUser(final UserInfoData user);

	UserInfoData getCurrentUser();

	void cleanUserInformation();
}
