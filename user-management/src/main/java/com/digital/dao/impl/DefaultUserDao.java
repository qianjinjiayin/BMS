package com.digital.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.digital.dao.UserDao;
import com.digital.dao.repo.UserRepository;
import com.digital.model.UserInfoModel;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
@Repository
public class DefaultUserDao implements UserDao
{
	@Resource
	private UserRepository userRepository;

	@Override
	public UserInfoModel findById(final long id)
	{
		return userRepository.findOne(id);
	}

	@Override
	public void save(final UserInfoModel user)
	{
		final List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		final Iterable<UserInfoModel> users = userRepository.findAll();
		if (users != null)
		{
			final Iterator<UserInfoModel> it = users.iterator();
			while (it.hasNext())
			{
				list.add(it.next());
			}
		}

		userRepository.save(user);
	}

	@Override
	public void update(final UserInfoModel user)
	{
		userRepository.save(user);
	}

	@Override
	public void delete(final UserInfoModel user)
	{
		userRepository.delete(user);
	}

	@Override
	public void delete(final long id)
	{
		userRepository.delete(id);
	}

	@Override
	public UserInfoModel findByEmail(final String email)
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public UserInfoModel findByEmailAndPassword(final String email, final String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public List<UserInfoModel> findAll(final UserInfoModel user)
	{
		final List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		final Iterable<UserInfoModel> users = userRepository.findAll();
		if (users != null)
		{
			final Iterator<UserInfoModel> it = users.iterator();
			while (it.hasNext())
			{
				list.add(it.next());
			}
		}
		return list;
	}

	@Override
	public List<UserInfoModel> searchUser(final UserInfoModel userInfoModel)
	{
		System.out.println(userInfoModel);
		final String name = "%" + userInfoModel.getName() + "%";
		final String email = "%" + userInfoModel.getEmail() + "%";
		final String cardno = "%" + userInfoModel.getCardno() + "%";
		final String type = userInfoModel.getType();

		final List<UserInfoModel> list = userRepository.findByNameLikeAndEmailLikeAndCardnoLikeAndType(name, email, cardno, type);
		return list;
	}
}
