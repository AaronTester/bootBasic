package com.aaron.controller;

import com.aaron.mapper.DepartmentMapper;
import com.aaron.mapper.EmployeeMapper;
import com.aaron.pojo.Department;
import com.aaron.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/18
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String queryUserList(Model model) {
        Collection<Employee> employees = employeeMapper.queryEmpList();
        model.addAttribute("employees",new ArrayList<Employee>(employees));
        return "emppage/empslist";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model) {
        List<Department> deptList = departmentMapper.getDeptList();
        model.addAttribute("deptList", deptList);
        return "emppage/addEmp";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model) {
        Employee employee = employeeMapper.queryEmp(id);
        model.addAttribute("employee", employee);
        List<Department> deptList = departmentMapper.getDeptList();
        model.addAttribute("deptList", deptList);
        return "emppage/updateEmp";
    }

    @PostMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Employee employee) {
        System.out.println(employee);
        employeeMapper.addEmp(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        int result = employeeMapper.delEmp(id);
        return "redirect:/emps";
    }
}
