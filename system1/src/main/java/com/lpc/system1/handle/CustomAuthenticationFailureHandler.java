package com.lpc.system1.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @CreateTime 2023/2/25-23:07
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Slf4j
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseMessage responseMessage= ResponseMessage.newInstancec(ResponseMessageEnum.LOGIN_FAIL);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().println(objectMapper.writeValueAsString(responseMessage));
    }
}
