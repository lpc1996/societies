package com.lpc.system1.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @CreateTime 2023/2/26-0:12
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ResponseMessage responseMessage = ResponseMessage.newInstancec(ResponseMessageEnum.REQUEST_SUCCESS);
        responseMessage.setData("index");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().println(objectMapper.writeValueAsString(responseMessage));
    }
}
