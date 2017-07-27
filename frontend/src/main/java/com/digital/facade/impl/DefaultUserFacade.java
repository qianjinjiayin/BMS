package com.digital.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.digital.data.UserData;
import com.digital.facade.UserFacade;
import com.digital.service.SessionService;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
@Component
public class DefaultUserFacade implements UserFacade
{

	@Resource(name = "defaultSessionService")
	private SessionService sessionService;

	@Override
	public boolean isUserLoggedIn()
	{
		final UserData user = sessionService.getCurrentUser();
		if (user == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public void saveUserToSession(final UserData user)
	{
		sessionService.saveUser(user);
	}

	@Override
	public void clearSession()
	{
		sessionService.cleanUserInformation();
	}

}
