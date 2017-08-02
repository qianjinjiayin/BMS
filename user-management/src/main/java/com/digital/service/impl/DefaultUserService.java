package com.digital.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.digital.dao.UserDao;
import com.digital.domain.mapper.Mapper;
import com.digital.domain.mapper.MapperFactory;
import com.digital.model.UserInfoModel;
import com.digital.service.UserService;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
@Service
public class DefaultUserService implements UserService
{
	private final Mapper MAPPER = MapperFactory.getMapper();

	@Resource(name = "defaultUserDao")
	private UserDao userDao;

	@Override
	@Transactional
	public UserInfoModel createUser(final UserInfoModel userInfoModel)
	{
		userInfoModel.setInitialState();
		userInfoModel.setInitialCardNo();
		System.out.println(userInfoModel);
		userDao.save(userInfoModel);
		return userInfoModel;
	}

	@Override
	public boolean checkIfExisting(final String email)
	{
		final UserInfoModel userInfoModel = userDao.findByEmail(email);
		return userInfoModel != null ? true : false;
	}

	@Override
	public boolean checkIfExisting(final String email, final String password)
	{
		final UserInfoModel userInfoModel = userDao.findByEmailAndPassword(email, password);
		return userInfoModel != null ? true : false;
	}

	@Override
	public List<UserInfoModel> findAllUser(final UserInfoModel userInfoModel)
	{
		final List<UserInfoModel> list = userDao.findAll(userInfoModel);
		System.out.println(userInfoModel);
		return list;
	}

	@Override
	public List<UserInfoModel> searchUser(final UserInfoModel userInfoModel)
	{
		final List<UserInfoModel> list = userDao.searchUser(userInfoModel);
		System.out.println(userInfoModel);
		return list;
	}

	@Override
	public UserInfoModel findUserById(final long id)
	{
		return userDao.findById(id);
	}

	@Override
	public UserInfoModel updateUser(final UserInfoModel newUserInfoModel)
	{
		final long id = newUserInfoModel.getId();
		final UserInfoModel originalUserInfoModel = userDao.findById(id);
		MAPPER.map(newUserInfoModel, originalUserInfoModel);
		originalUserInfoModel.registerUpdate();
		userDao.save(originalUserInfoModel);
		return originalUserInfoModel;
	}
}
