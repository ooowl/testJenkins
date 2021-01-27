package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author abserver
 * @date 2020/11/22
 */
public interface HomepageUserDao
        extends JpaRepository<HomepageUser, Long> {

    /**
     * 通过用户名寻找数据记录
     *
     * @param username username
     * @return HomepageUser
     */
    HomepageUser findByUsername(String username);
}