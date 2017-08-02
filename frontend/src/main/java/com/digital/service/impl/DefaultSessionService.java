package com.digital.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.domain.data.UserInfoData;
import com.digital.service.SessionService;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
@Service
public class DefaultSessionService implements SessionService
{
	@Autowired
	private HttpServletRequest request;

	private HttpSession getSession()
	{
		HttpSession session = null;
		try
		{
			session = request.getSession();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return session;
	}

	@Override
	public void saveUser(final UserInfoData user)
	{
		final HttpSession session = getSession();
		session.setAttribute(CURRENT_USER, user);
	}

	@Override
	public UserInfoData getCurrentUser()
	{
		final HttpSession session = getSession();
		final UserInfoData user = (UserInfoData) session.getAttribute(CURRENT_USER);
		return user;
	}

	@Override
	public void cleanUserInformation()
	{
		final HttpSession session = getSession();
		session.removeAttribute(CURRENT_USER);
	}
}
