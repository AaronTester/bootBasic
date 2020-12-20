package com.aaron.controller;

import com.aaron.mapper.EmployeeMapper;
import com.aaron.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/16
 */
@Controller
public class LoginController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/login")
    public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            Employee Employee = employeeMapper.queryEmp(2);
            request.getSession().setAttribute("EMPLOYEE_SESSION", Employee);
            return "redirect:/main.html";
        }else {
            model.addAttribute("errmsg", "用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String test(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
}
