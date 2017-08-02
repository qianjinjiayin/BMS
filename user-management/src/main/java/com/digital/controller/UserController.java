package com.digital.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.validation.ValidationResult;
import com.digital.facade.UserFacade;


/**
 * @author jiayin.wang
 * @date 2017-07-28
 */
@RestController()
public class UserController
{
	@Resource(name = "defaultUserFacade")
	private UserFacade userFacade;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String welcome(final Model model)
	{
		return "success";
	}

	@RequestMapping(value = "/createUser")
	public ValidationResult createUser(@RequestBody final UserInfoData userInfoData)
	{
		System.out.println("UserManagement===>>>createUser!!---------------------------------");
		System.out.println(userInfoData);

		final String email = userInfoData.getEmail();
		System.out.println("email ===>>>" + email + "<<<");

		final boolean existing = userFacade.checkIfExisting(email);
		final ValidationResult validationResult = new ValidationResult();
		if (existing)
		{
			validationResult.setPass(false);
			validationResult.addMsg(email + " is existing!");
		}
		else
		{
			final UserInfoData newUserInfoData = userFacade.createUser(userInfoData);
			validationResult.addMsg("Registration Successful!");
		}
		return validationResult;
	}

	@RequestMapping(value = "/updateUser")
	public ValidationResult updateUser(@RequestBody final UserInfoData userInfoData)
	{
		System.out.println("UserManagement===>>>updateUser!!---------------------------------");
		System.out.println(userInfoData);

		final ValidationResult validationResult = new ValidationResult();
		final UserInfoData updatedUserInfoData = userFacade.updateUser(userInfoData);
		validationResult.addMsg("Update Successful!");

		return validationResult;
	}

	@RequestMapping(value = "/validateLogin")
	public ValidationResult validateLogin(@RequestBody final UserInfoData userInfoData)
	{
		System.out.println("UserManagement===>>>validateLogin!!---------------------------------");
		System.out.println(userInfoData);

		final String email = userInfoData.getEmail();
		final String password = userInfoData.getPassword();

		final boolean existing = userFacade.checkIfExisting(email, password);
		final ValidationResult validationResult = new ValidationResult();
		if (!existing)
		{
			validationResult.setPass(false);
			validationResult.addMsg("Please enter the correct email and password!");
		}
		else
		{
			validationResult.addMsg("Login Successful!");
		}
		return validationResult;
	}

	@RequestMapping(value = "/findAll")
	public List<UserInfoData> findAllUser(@RequestBody final UserInfoData userInfoData)
	{
		final List<UserInfoData> newUserInfoData = userFacade.findAllUser(userInfoData);
		return newUserInfoData;
	}

	@RequestMapping(value = "/search")
	public List<UserInfoData> searchUser(@RequestBody final UserInfoData userInfoData)
	{
		final List<UserInfoData> newUserInfoData = userFacade.searchUser(userInfoData);
		return newUserInfoData;
	}

	@RequestMapping(value = "/findUserById")
	public UserInfoData findUserById(@RequestParam("id") final String id)
	{
		final UserInfoData userInfoData = userFacade.findUserById(id);
		return userInfoData;
	}
}
