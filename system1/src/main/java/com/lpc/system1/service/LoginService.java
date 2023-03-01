package com.lpc.system1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lpc.system1.model.LoginInfo;
import com.lpc.system1.model.User;
import com.lpc.system1.model.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CreateTime 2023/2/27-22:14
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

public interface LoginService extends IService<User> {
    /**
     * 用户登录
     * @param loginInfo
     * @return
     */
    public ResponseMessage login(LoginInfo loginInfo);
}
