package com.mjl.water_electricity_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mjl.water_electricity_manager.domain.BillingHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BillingHistoryMapper extends BaseMapper<BillingHistory> {
}