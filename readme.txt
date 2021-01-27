

项目名：
    imooc-homepage-spring-cloud

服务：
    1. homepage-eureka
    2. homepage-zuul
    3. homepage-course
    4. homepage-user
模块：
    1. imooc-homepage-spring-cloud
        2. homepage-eureka
        3. homepage-zuul
        4. imooc-homepage-service
            5. homepage-common
            6. homepage-course
            7. homepage-user

模块依赖：
    1. imooc-homepage-spring-cloud
        spring-boot-starter-parent(parent)
        lombok
        spring-boot-starter-test

    2. homepage-eureka
        spring-cloud-starter-netflix-eureka-server

    3. homepage-zuul
        spring-cloud-starter-netflix-eureka-client
        spring-cloud-starter-netflix-zuul
        commons-io

    4. imooc-homepage-service
        fastjson
        commons-codec

    5. homepage-common

    6. homepage-course
        spring-boot-starter-web
        spring-cloud-starter-netflix-eureka-client
        spring-boot-starter-data-jpa
        mysql-connector-java
        homepage-common

    7. homepage-user
        spring-boot-starter-web
        spring-cloud-starter-netflix-eureka-client
        spring-boot-starter-data-jpa
        spring-cloud-starter-openfeign
        spring-cloud-starter-netflix-hystrix
        homepage-common

服务、模块之间层级结构
    1. homepage-course  -- 提供课程服务
        1. 不使用网关结构：
            对外提供服务：
                1 GET http://127.0.0.1:7001/homepage-course/get/course?id=[8, 9]
                    homepage-course(springboot) -> jpa -> mysql
                2 POST http://127.0.0.1:7001/homepage-course/get/courses {"ids":[8,9]}
                    homepage-course(springboot) -> jpa -> mysql
        2. 使用网关：
            GET http://127.0.0.1:9000/imooc/homepage-course/get/course?id=8
                zuul -> homepage-course(springboot) -> jpa -> mysql

    2. homepage-user  -- 提供用户服务
        1. 网关：
            http://127.0.0.1:9000/imooc/homepage-user/create/user POST {"username":"qinyi","email":"xxx"}

            GET http://127.0.0.1:9000/imooc/homepage-user/get/user?id=9
                zuul -> homepage-user -> jpa -> mysql

            GET http://127.0.0.1:9000/imooc/homepage-user/get/user/course?id=9
                zuul -> homepage-user -> homepage-course(feign) -> jpa -> mysql

运行说明：
    0. 准备步骤
        a. 修改数据库连接串，密码
        b. 添加host：
            127.0.0.1 server1
            127.0.0.1 server2
            127.0.0.1 server3
    1. 运行建表SQL
    2. 运行插入SQL
    3. 运行4个服务
    4. 调用服务
        http://127.0.0.1:9000/imooc/homepage-course/get/course?id=8
        http://127.0.0.1:9000/imooc/homepage-course/get/courses body:{"ids":[8,9]}
        http://127.0.0.1:9000/imooc/homepage-user/get/user?id=10
        http://127.0.0.1:9000/imooc/homepage-user/get/user/course?id=10
    5. 亦可使用course、user的单元测试单独运行以插入数据，然后查看数据id以调用接口