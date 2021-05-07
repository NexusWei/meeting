package com.nexus.meeting.interceptor;

import com.nexus.meeting.model.Employee;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissInterceptor implements HandlerInterceptor {

    // AntPathMatcher 路径匹配
    AntPathMatcher pathMatcher = new AntPathMatcher();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
        String requestURI = request.getRequestURI();
//        System.out.println(requestURI);

        // 匿名就能访问的页面
        if ("/".equals(requestURI) || "/doLogin".equals(requestURI) || "/register".equals(requestURI) || "/doReg".equals(requestURI)) {
            // 返回true，让页面继续向下走。
            return true;
        }
        HttpSession session = request.getSession(true);
        Employee currentuser = (Employee) session.getAttribute("currentuser");

        // ？ 匹配一个字符
        // * 匹配0个或者多个字符
        // ** 匹配url中的0个或多个子目录
        // {spring:[a-z]+} 匹配满足正则表达式[a-z]+的路径，这些路径赋值给变量"spring"

        // 想访问admin下的文件，需要有admin权限。
        if (pathMatcher.match("/admin/**", requestURI)) {
            // 如果session中的用户不为空，且角色等于2，说明是管理员。
            // 判断细化，首先判断session中的用户不为空
            if (currentuser != null) {
                // 如果session中的角色等于2，说明是管理员
                if (currentuser.getRole() == 2) {
                    return true;
                }else {
                    // 如果session中的角色不等于2，说明不是管理员，返回一个403，权限不足，禁止访问
                    // 设置编码格式为中文，避免中文乱码
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("content-type","text/html;charset=UTF-8");
                    response.getWriter().write("403，权限不足，禁止访问");
                    return false;
                }
            }
        }else {
            // 否则，就是普通路径，只要登录了就行。
            if (currentuser != null) {
                return true;
            }
        }
        // 重定向到登录页面
        response.sendRedirect("/");
        return false;
    }
}
