package com.digital.facade;

import java.util.List;

import com.digital.domain.data.UserInfoData;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public interface UserFacade
{

	UserInfoData createUser(UserInfoData userInfoData);

	boolean checkIfExisting(String email);

	boolean checkIfExisting(String email, String password);

	List<UserInfoData> findAllUser(UserInfoData userInfoData);

	List<UserInfoData> searchUser(UserInfoData userInfoData);

	UserInfoData findUserById(String id);

	UserInfoData updateUser(UserInfoData userInfoData);
}
