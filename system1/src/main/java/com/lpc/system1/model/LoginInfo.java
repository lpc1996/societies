package com.lpc.system1.model;

import lombok.Data;

/**
 * @CreateTime 2023/2/21-22:25
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Data
public class LoginInfo {

    private String userName;

    private String pass;

    private String rememberMe;
}
