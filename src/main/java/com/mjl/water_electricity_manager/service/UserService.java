package com.mjl.water_electricity_manager.service;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.Dormitory;
import com.mjl.water_electricity_manager.domain.User;
import com.mjl.water_electricity_manager.domain.UserType;
import com.mjl.water_electricity_manager.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public static User loginUser = null;

    @Resource
    private UserMapper userMapper;


    @Resource
    private DormitoryBuildingService dormitoryBuildingService;

    @Resource
    private DormitoryService dormitoryService;

    @Resource
    private UserTypeService userTypeService;

    public List<User> searchByDormitoryId(Integer dormitoryId) {
        return baseMapper.searchByDormitoryId(dormitoryId);
    }

    public User login(String account, String password) {
        password = DigestUtil.md5Hex(password);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", account).eq("password", password)
                .or().eq("email", account).eq("password", password);
        return userMapper.selectOne(userQueryWrapper);
    }

    public void insertUser(User user) {
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        userMapper.insertUser(user);
    }

    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    public List<User> selectUser(String id, String name, Integer currentDormitoryId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (id != null && !id.equals("")) {
            queryWrapper.eq("id", id);
        }
        if (name != null && !name.equals("")) {
            queryWrapper.like("name", name);
        }
        if (currentDormitoryId != null) {
            queryWrapper.eq("dormitory_id", currentDormitoryId);
        }
        return userMapper.selectList(queryWrapper);
    }

    public List<User> selectUser(String id, String name, String type, String gender, Integer ageL, Integer ageR, String phone, String email, String dormitoryName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (id != null && !id.equals("")) {
            queryWrapper.eq("id", id);
        }
        if (name != null && !name.equals("")) {
            queryWrapper.like("name", name);
        }
        List<UserType> userTypes = userTypeService.selectUserType(type);
        List<Integer> userTypeIds = userTypes.stream().map(UserType::getId).toList();
        if (userTypes.size() > 0) {
            queryWrapper.in("user_type_id", userTypeIds);
        }
        if (ageL != 0 || ageR != 0) {
            queryWrapper.between("age", ageL, ageR);
        }
        if (phone != null && !phone.equals("")) {
            queryWrapper.like("phone", phone);
        }
        if (email != null && !email.equals("")) {
            queryWrapper.like("email", email);
        }
        if (dormitoryName != null && !dormitoryName.equals("")) {
            List<Dormitory> dormitories = dormitoryService.selectDormitory(null, dormitoryName);
            List<Integer> dormitoryIds = dormitories.stream().map(Dormitory::getId).toList();
            if (dormitories.size() > 0) {
                queryWrapper.in("dormitory_id", dormitoryIds);
            }
        }
        return userMapper.selectList(queryWrapper);
    }


    public User getByEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        return userMapper.selectOne(queryWrapper);
    }

    public User getByPhone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return userMapper.selectOne(queryWrapper);
    }

    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }
}
