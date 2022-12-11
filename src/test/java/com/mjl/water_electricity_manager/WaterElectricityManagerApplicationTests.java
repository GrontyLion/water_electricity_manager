package com.mjl.water_electricity_manager;

import com.mjl.water_electricity_manager.domain.User;
import com.mjl.water_electricity_manager.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WaterElectricityManagerApplicationTests {
    @Resource
    private UserMapper userMapper;

    static {
        System.setProperty("java.awt.headless", "false");

    }

    @Test
    void contextLoads() {
        System.setProperty("java.awt.headless", "false");

        User user = User.builder().name("ll")
                .age(12)
                .gender("M")
                .phone("12345678901")
                .email("53174219976@qq.com")
                .userTypeId(1)
                .dormitoryId(2)
                .password("e10adc3949ba59abbe56e057f20f883e")
                .build();
        userMapper.insertUser(user);
    }

}
