package com.lpc.system1.filter;

import cn.hutool.jwt.JWTUtil;
import com.lpc.system1.config.Redies.RedisCache;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import com.lpc.system1.util.JwtUtils;
import com.lpc.system1.util.WebUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @CreateTime 2023/2/27-21:34
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisCache redisCache;
    @Autowired
    JwtUtils jwtUtils;

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        String userId;
        // 解析token
        try{
            Claims claims = jwtUtils.analyzePayLoad(token);
            userId = claims.getSubject();
        }catch (Exception e){
            logger.error("解析token失败");
            WebUtils.renderString(response, ResponseMessage.toJsonString(ResponseMessage.newInstancec(ResponseMessageEnum.LOGIN_FAIL)));
        }

        filterChain.doFilter(request,response);
    }
}
