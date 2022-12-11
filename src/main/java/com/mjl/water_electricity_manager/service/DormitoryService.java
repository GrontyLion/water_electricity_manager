package com.mjl.water_electricity_manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.Dormitory;
import com.mjl.water_electricity_manager.mapper.DormitoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DormitoryService extends ServiceImpl<DormitoryMapper, Dormitory> {

    @Resource
    private DormitoryMapper dormitoryMapper;

    @Resource
    private DormitoryBuildingService dormitoryBuildingService;

    public List<Dormitory> selectDormitoryByDormitoryBuildingId(Integer dormitoryBuildingId) {
        QueryWrapper<Dormitory> q = new QueryWrapper<>();
        q.eq("dormitory_building_id", dormitoryBuildingId);
        return dormitoryMapper.selectList(q);
    }

    public List<Dormitory> selectDormitory(String id, String name) {
        QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
        if (id != null && !id.equals("")) {
            queryWrapper.eq("id", id);
        }
        if (name != null && !name.equals("")) {
            queryWrapper.like("name", name);
        }
        return dormitoryMapper.selectList(queryWrapper);
    }

    public boolean insertDormitory(String dormitoryName, int capacity, int dormitoryBuildingId) {
        Dormitory dormitory = new Dormitory();
        dormitory.setName(dormitoryName);
        dormitory.setCapacity(capacity);
        dormitory.setOccupied(0);
        dormitory.setDormitoryBuildingId(dormitoryBuildingId);

        // 触发器回去更新宿舍楼的总人数和总房间数
        return dormitoryMapper.insert(dormitory) > 0;
    }
}
