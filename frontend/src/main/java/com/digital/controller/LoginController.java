package com.digital.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.validation.ValidationResult;
import com.digital.facade.UserFacade;
import com.digital.feign.BMSFeignClient;


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
	@Autowired
	private BMSFeignClient feignClient;

	/**
	 * Login page.
	 *
	 * @param model
	 * @return login page
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
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public @ResponseBody Object validateLogin(@RequestParam(name = "username", required = true) final String email,
			@RequestParam(name = "password", required = true) final String pwd, final Model model)
	{
		final UserInfoData userInfoData = new UserInfoData(email, pwd);
		System.out.println(userInfoData);

		final ValidationResult validationResult = feignClient.validateLogin(userInfoData);
		return validationResult;
	}

	/**
	 * @param name
	 * @param pwd
	 * @param model
	 * @return home page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username", required = true) final String name,
			@RequestParam(name = "password", required = true) final String pwd, final Model model)
	{
		final UserInfoData user = new UserInfoData(name, pwd);
		System.out.println(user);
		userFacade.saveUserToSession(user);
		return REDIRECT_HOME_PAGE;
	}

	/**
	 * logout
	 *
	 * @return login page
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout()
	{
		userFacade.clearSession();
		return REDIRECT_LOGIN_PAGE;
	}
}
