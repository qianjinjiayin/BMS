package com.digital.dao.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.digital.model.UserInfoModel;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public interface UserRepository extends CrudRepository<UserInfoModel, Long>
{
	UserInfoModel findByEmail(String email);

	UserInfoModel findByEmailAndPassword(String email, String password);

	List<UserInfoModel> findByNameLikeAndEmailLikeAndCardnoLikeAndType(String name, String email, String cardno, String type);
}
