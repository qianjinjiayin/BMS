package com.digital.controller;

import org.springframework.ui.Model;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public abstract class AbstractController
{
	public static final String REDIRECT_PREFIX = "redirect:";
	public static final String FORWARD_PREFIX = "forward:";
	public static final String ROOT = "/";
	public static final String INDEX_PAGE = "index";

	protected void setupNavigation(final Model model, final String desNav)
	{
		model.addAttribute("navName", desNav);
		model.addAttribute("navTemplate", "fragment/navigation");
		model.addAttribute("navFragment", "copy");
	}

	protected void setupPageInfo(final Model model, final String title, final String pageName)
	{
		model.addAttribute("title", title);
		model.addAttribute("pageName", pageName);
	}

	protected void setupPageLayout(final Model model, final String mainTemplate, final String mainFragment)
	{
		model.addAttribute("mainTemplate", mainTemplate);
		model.addAttribute("mainFragment", mainFragment);
	}

}
