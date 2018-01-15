package com.wang.business.service;

import com.wang.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by wangyongwei on 2017/8/21.
 */
public interface IUserService extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findById(Integer id);


}
