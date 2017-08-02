package com.digital.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.validation.ValidationResult;


/**
 * @author jiayin.wang
 * @date 2017-07-21
 */
@Component
public class BMSFeignClientFallback implements BMSFeignClient
{

	@Override
	public String consumer()
	{
		return "fallback";
	}

	@Override
	public ValidationResult createUser(final UserInfoData userInfoData)
	{
		return null;
	}

	@Override
	public ValidationResult updateUser(final UserInfoData userInfoData)
	{
		return null;
	}

	@Override
	public ValidationResult validateLogin(final UserInfoData userInfoData)
	{
		return null;
	}

	@Override
	public List<UserInfoData> findAllUserConsumer(final UserInfoData userInfoData)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserInfoData> searchUserConsumer(final UserInfoData userInfoData)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoData findUserById(final String userId)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
