package com.imooc.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author abserver
 * @date 2020/11/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;
    private String username;
    private String email;

    public static UserInfo invalid() {
        return new UserInfo(-1L, "", "");
    }
}