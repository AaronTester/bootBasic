package com.aaron.config;

import com.aaron.pojo.Employee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/17
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Employee user_session = (Employee) request.getSession().getAttribute("EMPLOYEE_SESSION");
        if(user_session == null) {
            request.setAttribute("errmsg","用户没有登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
