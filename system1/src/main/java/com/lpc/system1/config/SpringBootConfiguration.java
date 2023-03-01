/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.config;

import cn.fly.jquicker.JQuicker;
import cn.fly.jquicker.JWTDefaultExpirationTime;
import cn.fly.jquicker.JWTDefaultSecretKey;
import com.lpc.system1.util.JwtUtils;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @CreateTime 2023/2/18-22:32
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 */

@Slf4j
@Configuration
public class SpringBootConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowCredentials(false)
                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").allowedOrigins("*");
            }
        };
    }

    @Bean
    public JwtUtils jQuicker(){
        JwtUtils jQuicker = new JwtUtils();
        //关闭默认构造器
        jQuicker.defaultBuilder(false);
        //自定义加密算法
        jQuicker.initSignatureAlgorithm(SignatureAlgorithm.HS384);
        //自定义加密密钥
        jQuicker.initSecretKey(JWTDefaultSecretKey.HS384_SECRET_KEY);
        //自定义过期时间
        jQuicker.initExpirationTime(JWTDefaultExpirationTime.HALF_MONTH);
        return jQuicker;
    }
}
