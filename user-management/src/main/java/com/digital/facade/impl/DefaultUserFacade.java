package com.digital.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.mapper.Mapper;
import com.digital.domain.mapper.MapperFactory;
import com.digital.facade.UserFacade;
import com.digital.model.UserInfoModel;
import com.digital.service.UserService;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
@Component
public class DefaultUserFacade implements UserFacade
{
	private final Mapper MAPPER = MapperFactory.getMapper();

	@Resource(name = "defaultUserService")
	private UserService userService;

	@Override
	public UserInfoData createUser(final UserInfoData userInfoData)
	{
		final UserInfoModel userInfoModel = MAPPER.map(userInfoData, UserInfoModel.class);
		final UserInfoModel newUserInfoModel = userService.createUser(userInfoModel);
		return MAPPER.map(newUserInfoModel, UserInfoData.class);
	}

	@Override
	public boolean checkIfExisting(final String email)
	{
		final boolean existing = userService.checkIfExisting(email);
		return existing;
	}

	@Override
	public boolean checkIfExisting(final String email, final String password)
	{
		final boolean existing = userService.checkIfExisting(email, password);
		return existing;
	}

	@Override
	public List<UserInfoData> findAllUser(final UserInfoData userInfoData)
	{
		final UserInfoModel userInfoModel = MAPPER.map(userInfoData, UserInfoModel.class);
		final List<UserInfoModel> newUserInfoModels = userService.findAllUser(userInfoModel);
		return MAPPER.map(newUserInfoModels, UserInfoData.class);
	}

	@Override
	public List<UserInfoData> searchUser(final UserInfoData userInfoData)
	{
		final UserInfoModel userInfoModel = MAPPER.map(userInfoData, UserInfoModel.class);
		final List<UserInfoModel> newUserInfoModels = userService.searchUser(userInfoModel);
		return MAPPER.map(newUserInfoModels, UserInfoData.class);
	}

	@Override
	public UserInfoData findUserById(final String id)
	{
		final UserInfoModel UserInfoModel = userService.findUserById(Long.valueOf(id).longValue());
		return MAPPER.map(UserInfoModel, UserInfoData.class);
	}

	@Override
	public UserInfoData updateUser(final UserInfoData userInfoData)
	{
		final UserInfoModel userInfoModel = MAPPER.map(userInfoData, UserInfoModel.class);
		System.out.println("com.digital.facade.impl.DefaultUserFacade.updateUser(UserInfoData)");
		System.out.println(userInfoModel);
		final UserInfoModel updatedUserInfoModel = userService.updateUser(userInfoModel);
		return MAPPER.map(updatedUserInfoModel, UserInfoData.class);
	}

}
