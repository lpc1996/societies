/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lpc.system1.model.LoginInfo;
import com.lpc.system1.model.User;
import com.lpc.system1.model.response.ResponseMessage;

/**
 *负责处理用户操作的
 */
public interface UserService extends IService<User> {



    public ResponseMessage insert(User user);

}
