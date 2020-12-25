package com.aaron.mapper;

import com.aaron.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/4/10
 */
@Mapper
public interface EmployeeMapper {
    Employee queryEmp(Integer id);
    List<Employee> queryEmpList();
    Employee getUserByName(String name);
    Employee queryEmpByNameAndPwd(Employee employee);
    Employee getEmployeeByEmpId(String empId);
    void addEmp(Employee employee);
    void insertBatch(List<Employee> list);
    int delEmp(Integer id);

}
