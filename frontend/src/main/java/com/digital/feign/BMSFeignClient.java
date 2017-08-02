package com.digital.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digital.domain.data.UserInfoData;
import com.digital.domain.validation.ValidationResult;


/**
 * @author 翟永超
 * @create 2017/6/24.
 * @blog http://blog.didispace.com
 */
@FeignClient(value = "user-management", fallback = BMSFeignClientFallback.class)
public interface BMSFeignClient
{

	@RequestMapping("/create")
	String consumer();

	@RequestMapping(value = "/createUser")
	ValidationResult createUser(@RequestBody UserInfoData userInfoData);

	@RequestMapping(value = "/updateUser")
	ValidationResult updateUser(@RequestBody UserInfoData userInfoData);

	@RequestMapping(value = "/validateLogin")
	ValidationResult validateLogin(@RequestBody UserInfoData userInfoData);

	@RequestMapping("/findAll")
	List<UserInfoData> findAllUserConsumer(@RequestBody UserInfoData userInfoData);

	@RequestMapping("/search")
	List<UserInfoData> searchUserConsumer(@RequestBody UserInfoData userInfoData);

	@RequestMapping("/findUserById")
	UserInfoData findUserById(@RequestParam("id") String id);


}
