package com.digital.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digital.data.UserData;
import com.digital.facade.UserFacade;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@Controller
public class LoginController extends AbstractController
{
	private static final String REDIRECT_HOME_PAGE = REDIRECT_PREFIX + "/home";
	private static final String REDIRECT_LOGIN_PAGE = REDIRECT_PREFIX + ROOT;

	@Resource(name = "defaultUserFacade")
	private UserFacade userFacade;


	/**
	 * Login page.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(final Model model)
	{
		final boolean isLoggedIn = userFacade.isUserLoggedIn();
		if (isLoggedIn)
		{
			return REDIRECT_HOME_PAGE;
		}
		return "login";
	}

	/**
	 * @param name
	 * @param pwd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "form-username", required = true) final String name,
			@RequestParam(name = "form-password", required = true) final String pwd, final Model model)
	{
		final UserData user = new UserData(name, pwd);
		userFacade.saveUserToSession(user);
		return REDIRECT_HOME_PAGE;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout()
	{
		userFacade.clearSession();
		return REDIRECT_LOGIN_PAGE;
	}
}
