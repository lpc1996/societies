package com.lpc.system1.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @CreateTime 2023/2/21-19:37
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */
public class WebUtils {

    /**
     * 将字符串渲染到客户端
     *
     * @param response
     * @param str
     * @return
     */
    public static void renderString(HttpServletResponse response, String str) {
        try {
            response.setStatus(200);
            response.setContentType("application/json;utf-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
