package com.mjl.water_electricity_manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.BillingHistory;
import com.mjl.water_electricity_manager.mapper.BillingHistoryMapper;
import org.springframework.stereotype.Service;
@Service
public class BillingHistoryService extends ServiceImpl<BillingHistoryMapper, BillingHistory> {

    public BillingHistory selectByIdAndYearMonth(Integer id, Integer year, Integer month) {
        QueryWrapper<BillingHistory> q = new QueryWrapper<>();
        q.eq("dormitory_building_id", id).eq("year", year).eq("month", month);
        return this.getOne(q);
    }
}
