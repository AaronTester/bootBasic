package com.aaron.controller;

import com.aaron.mapper.EmployeeMapper;
import com.aaron.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/test")
    public List<Employee> test() {
        List<Employee> employees = employeeMapper.queryEmpList();
        logger.info(employees.toString());
        logger.error(employees.toString());
        return employees;
    }
}
