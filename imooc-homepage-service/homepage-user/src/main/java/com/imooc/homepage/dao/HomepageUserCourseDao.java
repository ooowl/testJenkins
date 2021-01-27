package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author abserver
 * @date 2020/11/22
 */
public interface HomepageUserCourseDao
        extends JpaRepository<HomepageUserCourse, Long> {

    /**
     * 通过用户 id 寻找数据记录
     *
     * @param userId userId
     * @return List<HomepageUserCourse>
     */
    List<HomepageUserCourse> findAllByUserId(Long userId);
}