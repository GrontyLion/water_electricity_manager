package com.mjl.water_electricity_manager.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.WaterElectricityConsumption;
import com.mjl.water_electricity_manager.mapper.WaterElectricityConsumptionMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WaterElectricityConsumptionService extends ServiceImpl<WaterElectricityConsumptionMapper, WaterElectricityConsumption> {
    public List<WaterElectricityConsumption> searchByDormitoryId(Integer dormitoryId) {
        return baseMapper.searchByDormitoryId(dormitoryId);
    }


    public List<WaterElectricityConsumption> searchBy5Condition(Integer dormitoryId, Integer id, Double waterPrice, Double electricityPrice, Date date) {
        return baseMapper.searchBy5Condition(dormitoryId, id, waterPrice, electricityPrice, date);
    }
}
