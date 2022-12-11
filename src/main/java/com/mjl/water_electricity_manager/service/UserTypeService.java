package com.mjl.water_electricity_manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.UserType;
import com.mjl.water_electricity_manager.mapper.UserTypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTypeService extends ServiceImpl<UserTypeMapper, UserType> {

    public List<UserType> selectUserType(String type) {
        QueryWrapper<UserType> q = new QueryWrapper<>();
        if (type != null && !type.equals("")) {
            q.like("name", type);
        }
        return this.list(q);
    }
}
