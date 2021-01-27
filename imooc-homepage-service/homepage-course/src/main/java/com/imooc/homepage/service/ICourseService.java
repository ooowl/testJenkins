package com.imooc.homepage.service;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;

import java.util.List;

/**
 * @author abserver
 * @date 2020/11/22
 */
public interface ICourseService {

    /**
     * 通过 id 获取课程信息
     *
     * @param id id
     * @return CourseInfo
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过 ids 获取课程信息
     *
     * @param request request
     * @return List<CourseInfo>
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
