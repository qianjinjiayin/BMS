package com.digital.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.mapper.Mapper;
import com.digital.domain.mapper.MapperFactory;
import com.digital.domain.validation.ValidationResult;
import com.digital.feign.BMSFeignClient;
import com.digital.formData.UserInfoForm;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController
{
	private final Mapper MAPPER = MapperFactory.getMapper();

	@Autowired
	private BMSFeignClient feignClient;

	@RequestMapping(value = "/findAll")
	public String findAllUser(@ModelAttribute final UserInfoForm userInfoForm, final Model model)
	{
		final UserInfoData userInfoData = new UserInfoData();
		final List<UserInfoData> users = feignClient.findAllUserConsumer(userInfoData);
		model.addAttribute("userList", users);
		return "queryUser";
	}

	@RequestMapping(value = "/search")
	public String searchUser(@ModelAttribute final UserInfoForm userInfoForm, final Model model)
	{
		setupNavigation(model, ControllerConstants.Navigations.USER);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.USER, ControllerConstants.Views.Pages.Names.USER);
		setupPageLayout(model, ControllerConstants.Views.Templates.User.TEMPLATE_QUERY,
				ControllerConstants.Views.Templates.User.FRAGMENT_COPY);

		System.out.println(userInfoForm);
		final UserInfoData userInfoData = new UserInfoData();
		userInfoData.setName(userInfoForm.getUsername());
		userInfoData.setEmail(userInfoForm.getEmail());
		userInfoData.setType(userInfoForm.getType());
		userInfoData.setCardno(userInfoForm.getCardno());
		final List<UserInfoData> users = feignClient.searchUserConsumer(userInfoData);
		model.addAttribute("userList", users);
		model.addAttribute("userInfoForm", userInfoForm);

		return INDEX_PAGE;

	}

	@RequestMapping(value = "/createUserPage", method = RequestMethod.GET)
	public String createUserPage(final Model model)
	{
		setupNavigation(model, ControllerConstants.Navigations.USER);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.USER, ControllerConstants.Views.Pages.Names.USER);
		setupPageLayout(model, ControllerConstants.Views.Templates.User.TEMPLATE_CREATE,
				ControllerConstants.Views.Templates.User.FRAGMENT_COPY);
		return INDEX_PAGE;
	}

	@RequestMapping(value = "/updateUserPage")
	public String updateUserPage(final Model model, @RequestParam("userId") final String userId)
	{
		setupNavigation(model, ControllerConstants.Navigations.USER);
		setupPageInfo(model, ControllerConstants.Views.Pages.Titles.USER, ControllerConstants.Views.Pages.Names.USER);
		setupPageLayout(model, ControllerConstants.Views.Templates.User.TEMPLATE_UPDATE,
				ControllerConstants.Views.Templates.User.FRAGMENT_COPY);
		System.out.println("userId ===>>>" + userId + "<<<");
		System.out.println("userId ===>>>" + userId + "<<<");
		System.out.println("userId ===>>>" + userId + "<<<");

		if (StringUtils.isNotBlank(userId))
		{
			final UserInfoData userInfoData = feignClient.findUserById(userId);
			model.addAttribute("userInfo", userInfoData);
		}
		return INDEX_PAGE;
	}

	@RequestMapping(value = "/create")
	public @ResponseBody Object createUser(@ModelAttribute final UserInfoForm userInfoForm)
	{
		System.out.println("Frontend===>>>createUser!!---------------------------------");
		System.out.println(userInfoForm);

		final UserInfoData userInfoData = MAPPER.map(userInfoForm, UserInfoData.class);
		System.out.println(userInfoData);

		final ValidationResult validationResult = feignClient.createUser(userInfoData);
		return validationResult;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody Object updateUser(@ModelAttribute final UserInfoForm userInfoForm)
	{
		System.out.println("Frontend===>>>updateUser!!---------------------------------");
		System.out.println(userInfoForm);

		final UserInfoData userInfoData = MAPPER.map(userInfoForm, UserInfoData.class);
		System.out.println(userInfoData);

		final ValidationResult validationResult = feignClient.updateUser(userInfoData);
		return validationResult;
	}

}
