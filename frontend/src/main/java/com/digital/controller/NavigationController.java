package com.digital.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digital.service.SessionService;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
@Controller
public class NavigationController extends AbstractController
{

	@Resource(name = "defaultSessionService")
	private SessionService sessionService;

	/**
	 * Home page.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(final Model model)
	{
		setupNavigation(model, ControllerConstants.Navigations.HOME);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.HOME, ControllerConstants.Views.Pages.Names.HOME);
		setupPageLayout(model, ControllerConstants.Views.Templates.Home.TEMPLATE,
				ControllerConstants.Views.Templates.Home.FRAGMENT_BRIEF);
		return INDEX_PAGE;
	}


	@RequestMapping(value = "/queryUser")
	public String queryUser(final Model model)
	{
		return "queryUser";
	}


	/**
	 * User Management
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(final Model model)
	{
		setupNavigation(model, ControllerConstants.Navigations.USER);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.USER, ControllerConstants.Views.Pages.Names.USER);
		setupPageLayout(model, ControllerConstants.Views.Templates.User.TEMPLATE_QUERY,
				ControllerConstants.Views.Templates.User.FRAGMENT_COPY);
		return INDEX_PAGE;
	}

	/**
	 * Book Management
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String book(final Model model)
	{
		setupNavigation(model, ControllerConstants.Navigations.BOOK);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.BOOK, ControllerConstants.Views.Pages.Names.BOOK);
		setupPageLayout(model, ControllerConstants.Views.Templates.Book.TEMPLATE,
				ControllerConstants.Views.Templates.Book.FRAGMENT_COPY);
		return INDEX_PAGE;
	}
}
