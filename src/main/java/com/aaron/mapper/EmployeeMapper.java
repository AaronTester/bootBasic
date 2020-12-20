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
    public Employee queryEmp(Integer id);
    public void addEmp(Employee employee);
    public void insertBatch(List<Employee> list);
    public List<Employee> queryEmpList();
    public int delEmp(Integer id);
}
