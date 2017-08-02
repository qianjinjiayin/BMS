package com.digital.service;

import java.util.List;

import com.digital.model.UserInfoModel;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public interface UserService
{

	UserInfoModel createUser(UserInfoModel userInfoModel);

	boolean checkIfExisting(String email);

	boolean checkIfExisting(String email, String password);

	List<UserInfoModel> findAllUser(UserInfoModel userInfoModel);

	List<UserInfoModel> searchUser(UserInfoModel userInfoModel);

	UserInfoModel findUserById(long longValue);

	UserInfoModel updateUser(UserInfoModel userInfoModel);
}
