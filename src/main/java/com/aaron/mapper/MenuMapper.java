package com.aaron.mapper;

import com.aaron.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/22
 */
@Mapper
public interface MenuMapper {
    List<Menu> queryMenuList();
}
