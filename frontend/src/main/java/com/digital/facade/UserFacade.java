package com.digital.facade;

import com.digital.domain.data.UserInfoData;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public interface UserFacade
{

	boolean isUserLoggedIn();

	void saveUserToSession(UserInfoData user);

	void clearSession();

}
