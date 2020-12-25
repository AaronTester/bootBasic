package com.aaron.service.impl;

import com.aaron.mapper.MenuMapper;
import com.aaron.pojo.Menu;
import com.aaron.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/22
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenuList() {
        return menuMapper.queryMenuList();
    }
}
