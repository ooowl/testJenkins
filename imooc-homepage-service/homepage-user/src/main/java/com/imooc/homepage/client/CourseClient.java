package com.imooc.homepage.client;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 使用feign调用课程服务
 *
 * @author abserver
 * @date 2020/11/22
 */
@FeignClient(value = "eureka-client-homepage-course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {

    /**
     * 将[课程服务]中的获取单个课程接口，封装为getCourseInfo方法
     *
     * @param id 课程id
     * @return CourseInfo
     */
    @RequestMapping(value = "/homepage-course/get/course",
            method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    /**
     * 将[课程服务]中的获取多个课程接口，封装为getCourseInfos方法
     *
     * @param request 课程信息请求
     * @return List<CourseInfo>
     */
    @RequestMapping(value = "/homepage-course/get/courses",
            method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}