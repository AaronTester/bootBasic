package com.aaron.service.impl;

import com.aaron.mapper.EmployeeMapper;
import com.aaron.pojo.Employee;
import com.aaron.pojo.Permissions;
import com.aaron.pojo.Role;
import com.aaron.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/20
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee queryEmp(Integer id) {
        return employeeMapper.queryEmp(id);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
    }

    @Override
    public void insertBatch(List<Employee> list) {
        employeeMapper.insertBatch(list);
    }

    @Override
    public List<Employee> queryEmpList() {
        return employeeMapper.queryEmpList();
    }

    @Override
    public int delEmp(Integer id) {
        return employeeMapper.delEmp(id);
    }

    @Override
    public Employee getUserByName(String name) {
        return employeeMapper.getUserByName(name);
    }

    @Override
    public Employee getEmployeeByEmpId(String empId) {
        return employeeMapper.getEmployeeByEmpId(empId);
    }

    @Override
    public Employee queryEmpByNameAndPwd(Employee employee) {
        return employeeMapper.queryEmpByNameAndPwd(employee);
    }
}
