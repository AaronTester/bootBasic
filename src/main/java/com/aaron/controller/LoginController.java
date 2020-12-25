package com.aaron.controller;

import com.aaron.mapper.EmployeeMapper;
import com.aaron.pojo.Employee;
import com.aaron.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
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

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public String loginValidate(Employee employee, Model model, HttpServletRequest request) {
        if(StringUtils.isEmpty(employee.getEmpId()) && StringUtils.isEmpty(employee.getPassword())) {
            return "login";
        }
        if(StringUtils.isEmpty(employee.getEmpId()) || StringUtils.isEmpty(employee.getPassword())) {
            model.addAttribute("errmsg", "登录工号或密码不能为空");
            return "login";
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                employee.getEmpId(),
                employee.getPassword()
        );
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在！", e);
            model.addAttribute("errmsg", "用户名不存在！");
            return "login";
        } catch (AuthenticationException e) {
            logger.error("账号或密码错误！", e);
            model.addAttribute("errmsg", "账号或密码错误！");
            return "login";
        } catch (AuthorizationException e) {
            logger.error("没有权限！", e);
            model.addAttribute("errmsg", "没有权限！");
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String test(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
}
