package com.digital.dao;

import java.util.List;

import com.digital.model.UserInfoModel;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public interface UserDao
{
	UserInfoModel findById(long id);

	void save(UserInfoModel user);

	void update(UserInfoModel user);

	void delete(UserInfoModel user);

	void delete(long id);

	UserInfoModel findByEmail(String email);

	UserInfoModel findByEmailAndPassword(String email, String password);

	List<UserInfoModel> findAll(UserInfoModel user);

	List<UserInfoModel> searchUser(UserInfoModel userInfoModel);
}
