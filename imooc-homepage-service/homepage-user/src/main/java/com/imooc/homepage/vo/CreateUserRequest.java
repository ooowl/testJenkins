package com.imooc.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 创建用户请求对象定义
 *
 * @author abserver
 * @date 2020/11/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String email;

    /**
     * <h2>请求有效性验证</h2>
     * */
    public boolean validate() {

        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(email);
    }
}