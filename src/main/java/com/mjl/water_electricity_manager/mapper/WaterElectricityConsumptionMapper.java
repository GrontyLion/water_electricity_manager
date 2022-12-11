package com.mjl.water_electricity_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mjl.water_electricity_manager.domain.WaterElectricityConsumption;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface WaterElectricityConsumptionMapper extends BaseMapper<WaterElectricityConsumption> {
    List<WaterElectricityConsumption> searchByDormitoryId(Integer dormitoryId);

    List<WaterElectricityConsumption> searchBy5Condition(Integer dormitoryId, Integer id, Double waterPrice, Double electricityPrice, Date date);

}