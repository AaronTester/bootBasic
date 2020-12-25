package com.aaron.service;

import com.aaron.pojo.Employee;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/20
 */
public interface EmployeeService {

    Employee queryEmp(Integer id);
    List<Employee> queryEmpList();
    Employee getUserByName(String name);
    Employee getEmployeeByEmpId(String empId);
    Employee queryEmpByNameAndPwd(Employee employee);
    void addEmp(Employee employee);
    int delEmp(Integer id);
    void insertBatch(List<Employee> list);
}
