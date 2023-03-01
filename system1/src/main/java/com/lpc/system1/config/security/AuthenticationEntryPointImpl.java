package com.lpc.system1.config.security;

import cn.hutool.json.JSONUtil;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import com.lpc.system1.util.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @CreateTime 2023/2/27-22:59
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {
        log.error("进入到认证失败处理器,失败原因:{}", authException.getLocalizedMessage());
        WebUtils.renderString(response, JSONUtil.toJsonStr(ResponseMessage.newInstancec(ResponseMessageEnum.LOGIN_FAIL)));
    }
}
