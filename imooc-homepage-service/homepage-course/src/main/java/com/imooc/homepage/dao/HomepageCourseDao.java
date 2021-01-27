package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author abserver
 * @date 2020/11/22
 */
public interface HomepageCourseDao extends
        JpaRepository<HomepageCourse, Long> {
}