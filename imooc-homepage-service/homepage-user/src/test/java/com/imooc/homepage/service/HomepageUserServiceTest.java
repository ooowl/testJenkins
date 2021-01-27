package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.Application;
import com.imooc.homepage.dao.HomepageUserCourseDao;
import com.imooc.homepage.entity.HomepageUserCourse;
import com.imooc.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 用户服务测试用例
 *
 * @author abserver
 * @date 2020/11/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HomepageUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Test
//    @Transactional
    public void testCreateUser() {

        // {"email":"qinyi@imooc.com","id":6,"username":"qinyi"}

        System.out.println(JSON.toJSONString(
                userService.createUser(new CreateUserRequest(
                        "qinyi", "qinyi@imooc.com"
                ))
        ));
    }

    @Test
    public void testGetUserInfo() {

        // {"email":"qinyi@imooc.com","id":7,"username":"qinyi"}
        System.out.println(JSON.toJSONString(
                userService.getUserInfo(9L)
        ));
    }

    @Test
    public void testCreateHomepageUserCourse() {

        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(9L);
        course1.setCourseId(8L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(9L);
        course2.setCourseId(9L);

        System.out.println(userCourseDao.saveAll(
                Arrays.asList(course1, course2)
        ).size());
    }
}
