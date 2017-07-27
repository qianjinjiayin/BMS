package com.digital.facade;

import com.digital.data.UserData;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public interface UserFacade
{

	boolean isUserLoggedIn();

	void saveUserToSession(UserData user);

	void clearSession();

}
