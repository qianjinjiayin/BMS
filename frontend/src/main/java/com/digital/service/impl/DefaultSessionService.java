package com.digital.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.data.UserData;
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

	@Override
	public HttpSession getSession()
	{
		HttpSession session = null;
		try
		{
			session = request.getSession();
		}
		catch (final Exception e)
		{
		}
		return session;
	}

	@Override
	public void saveUser(final UserData user)
	{
		final HttpSession session = getSession();
		session.setAttribute("currentUser", user);
	}

	@Override
	public UserData getCurrentUser()
	{
		final HttpSession session = getSession();
		final UserData user = (UserData) session.getAttribute(CURRENT_USER);
		return user;
	}

	@Override
	public void cleanUserInformation()
	{
		final HttpSession session = getSession();
		session.removeAttribute(CURRENT_USER);
	}
}
