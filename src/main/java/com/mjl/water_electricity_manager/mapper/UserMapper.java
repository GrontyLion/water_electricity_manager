package com.mjl.water_electricity_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mjl.water_electricity_manager.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> searchByDormitoryId(Integer dormitoryId);

    void insertUser(User user);

    void updateUserById(User user);

    void deleteUserById(Integer id);

}