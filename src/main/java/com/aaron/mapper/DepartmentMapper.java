package com.aaron.mapper;

import com.aaron.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/4/10
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from tbl_department ")
    public List<Department> getDeptList();

    @Select("select * from tbl_department where id = #{id}")
    public Department getDept(Integer id);

    @Delete("delete from tbl_department where id = #{id}")
    public int delDept(Integer id);

    @Insert("insert into tbl_department(deptName) values (#{deptName})")
    public int addDept(Department department);

    @Update("update tbl_department set deptName = #{deptName} where id = #{id}")
    public int updateDept(Department department);
}
