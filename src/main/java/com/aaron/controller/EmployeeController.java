package com.aaron.controller;

import com.aaron.pojo.Department;
import com.aaron.pojo.Employee;
import com.aaron.service.DepartmentService;
import com.aaron.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
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
@ApiModel("用户处理类")
@Api("用户处理类")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String queryUserList(Model model) {
        Collection<Employee> employees = employeeService.queryEmpList();
        model.addAttribute("employees",new ArrayList<Employee>(employees));
        return "emppage/empslist";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model) {
        List<Department> deptList = departmentService.getDeptList();
        model.addAttribute("deptList", deptList);
        return "emppage/addEmp";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeService.addEmp(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model) {
        Employee employee = employeeService.queryEmp(id);
        model.addAttribute("employee", employee);
        List<Department> deptList = departmentService.getDeptList();
        model.addAttribute("deptList", deptList);
        return "emppage/updateEmp";
    }

    @PostMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Employee employee) {
        System.out.println(employee);
        employeeService.addEmp(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        int result = employeeService.delEmp(id);
        return "redirect:/emps";
    }
}
