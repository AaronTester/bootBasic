package com.aaron.controller;

import com.aaron.pojo.Employee;
import com.aaron.service.EmployeeService;
import com.aaron.service.impl.TestServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/19
 */
@RestController
@Api("swaggerDemoController相关的api")
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("/test")
    @ApiOperation(value="test")
    public List<Employee> test() {
        List<Employee> employees = employeeService.queryEmpList();
        System.out.println("-----------------------");
        testService.testAsyn();
        System.out.println("======================");
        return employees;
    }
}
