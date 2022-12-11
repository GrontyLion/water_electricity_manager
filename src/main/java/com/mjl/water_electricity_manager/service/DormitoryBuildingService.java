package com.mjl.water_electricity_manager.service;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjl.water_electricity_manager.domain.BillingHistory;
import com.mjl.water_electricity_manager.domain.Dormitory;
import com.mjl.water_electricity_manager.domain.DormitoryBuilding;
import com.mjl.water_electricity_manager.mapper.BillingHistoryMapper;
import com.mjl.water_electricity_manager.mapper.DormitoryBuildingMapper;
import com.mjl.water_electricity_manager.mapper.DormitoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DormitoryBuildingService extends ServiceImpl<DormitoryBuildingMapper, DormitoryBuilding> {

    @Resource
    private DormitoryBuildingMapper dormitoryBuildingMapper;

    @Resource
    private DormitoryMapper dormitoryMapper;

    @Resource
    private BillingHistoryMapper billingHistoryMapper;

    public List<DormitoryBuilding> selectDormitoryBuilding(String id, String dName, String name, String phone, String email, int renL, int renR, int janL, int janR) {
        QueryWrapper<DormitoryBuilding> queryWrapper = new QueryWrapper<>();
        if (id != null && !id.equals("")) {
            queryWrapper.eq("id", id);
        }
        if (dName != null && !dName.equals("")) {
            queryWrapper.like("name", dName);
        }
        if (name != null && !name.equals("")) {
            queryWrapper.like("leader_name", name);
        }
        if (phone != null && !phone.equals("")) {
            queryWrapper.like("leader_phone", phone);
        }
        if (email != null && !email.equals("")) {
            queryWrapper.like("leader_email", email);
        }
        if (renL != 0 || renR != 0) {
            queryWrapper.ge("total_capacity", renL);
            queryWrapper.le("total_capacity", renR);
        }
        if (janL != 0 || janR != 0) {
            queryWrapper.ge("total_room_number", janL);
            queryWrapper.le("total_room_number", janR);
        }
        return dormitoryBuildingMapper.selectList(queryWrapper);
    }

    @Transactional
    public boolean insertDormitoryBuilding(String dName, String jan, String name, String phone, String email, String numbers, String start, String ePrice, String wPrice, String oneFloor) {
        System.out.println("dName = " + dName);
        // numbers格式: 1,2,3,4,5,6，分别对应1人间，2人间，3人间，4人间，5人间，6人间的数量
        String[] split = numbers.split(",");
        int[] nums = new int[6];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int totalCapacity = nums[0] + nums[1] * 2 + nums[2] * 3 + nums[3] * 4 + nums[4] * 5 + nums[5] * 6;
        int totalRoomNumber1 = nums[0] + nums[1] + nums[2] + nums[3] + nums[4] + nums[5];

        int totalRoomNumber2 = Integer.parseInt(jan);
        if (totalRoomNumber2 != totalRoomNumber1) {
            JOptionPane.showMessageDialog(null, "总房间数与各类型房间数之和不相等");
            return false;
        }

        DormitoryBuilding dormitoryBuilding = new DormitoryBuilding();
        dormitoryBuilding.setSchoolId(1);
        dormitoryBuilding.setName(dName);
        dormitoryBuilding.setTotalRoomNumber(0);
        dormitoryBuilding.setTotalCapacity(0);
        dormitoryBuilding.setOccupiedCapacity(0);
        dormitoryBuilding.setOccupiedRoomNumber(0);
        dormitoryBuilding.setLeaderName(name);
        dormitoryBuilding.setLeaderPhone(phone);
        dormitoryBuilding.setLeaderEmail(email);

        boolean b1 = dormitoryBuildingMapper.insert(dormitoryBuilding) > 0;

        // 从start号开始，依次插入jan个寝室
        int startNum = Integer.parseInt(start);
        int floor = Integer.parseInt(oneFloor);
        int cf = 0;
        int cr = 0;
        int cur = 0;
        for (int i = 0; i < Integer.parseInt(jan); i++) {
            if (nums[cur] == 0) {
                cur++;
            }
            if (cr == floor) {
                cr = 0;
                cf++;
            }

            System.out.println("cf = " + cf + ", cr = " + cr + ", cur = " + cur + ", i = " + i);

            // 取startNum 的最高位，startNum的位数不确定
            int bits = (int) Math.pow(10, (startNum + "").length() - 1);

            Dormitory dormitory = Dormitory.builder().name(String.valueOf(startNum + i % floor + cf * bits))
                    .capacity(cur + 1)
                    .occupied(0)
                    .dormitoryBuildingId(dormitoryBuilding.getId()).build();
            boolean b2 = dormitoryMapper.insert(dormitory) > 0;
            if (!b2) {
                return false;
            }
            nums[cur]--;
            cr++;

        }

        // 插入电价和水价
        BillingHistory billingHistory = BillingHistory.builder().dormitoryBuildingId(dormitoryBuilding.getId())
                .electricityPrice(BigDecimal.valueOf(Double.parseDouble(ePrice)))
                .waterPrice(BigDecimal.valueOf(Double.parseDouble(wPrice)))
                .year(LocalDateTimeUtil.now().getYear())
                .month(LocalDateTimeUtil.now().getMonthValue())
                .build();

        boolean b3 = billingHistoryMapper.insert(billingHistory) > 0;
        return b1 && b3;
    }

    public boolean checkDormitoryBuildingHasPeople(int idInt) {
        QueryWrapper<DormitoryBuilding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", idInt);
        DormitoryBuilding dormitoryBuilding = dormitoryBuildingMapper.selectOne(queryWrapper);
        return dormitoryBuilding.getOccupiedCapacity() != 0;
    }

    @Transactional
    public boolean deleteDormitoryBuilding(int idInt) {
        QueryWrapper<DormitoryBuilding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", idInt);
        boolean b1 = dormitoryBuildingMapper.delete(queryWrapper) > 0;

        QueryWrapper<Dormitory> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("dormitory_building_id", idInt);
        boolean b2 = dormitoryMapper.delete(queryWrapper1) > 0;

        QueryWrapper<BillingHistory> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("dormitory_building_id", idInt);
        boolean b3 = billingHistoryMapper.delete(queryWrapper2) > 0;

        return b1 && b2 && b3;
    }

    public boolean updateDormitoryBuilding(int idInt, String dName, String name, String phone, String email, double ePriceDouble, double wPriceDouble) {
        DormitoryBuilding dormitoryBuilding = DormitoryBuilding.builder().id(idInt).name(dName).leaderName(name).leaderPhone(phone).leaderEmail(email).build();
        boolean b1 = dormitoryBuildingMapper.updateById(dormitoryBuilding) > 0;
        LocalDateTime nextMonth = LocalDateTimeUtil.now().plusMonths(1);
        QueryWrapper<BillingHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dormitory_building_id", idInt);
        queryWrapper.eq("year",nextMonth.getYear());
        queryWrapper.eq("month", nextMonth.getMonthValue());
        BillingHistory billingHistory1 = billingHistoryMapper.selectOne(queryWrapper);
        if (billingHistory1 == null) {
            // 获取下一个月的LocalDateTime
            BillingHistory billingHistory = BillingHistory.builder().dormitoryBuildingId(idInt)
                    .electricityPrice(BigDecimal.valueOf(ePriceDouble))
                    .waterPrice(BigDecimal.valueOf(wPriceDouble))
                    .year(nextMonth.getYear())
                    .month(nextMonth.getMonthValue())
                    .build();
            boolean b2 = billingHistoryMapper.insert(billingHistory) > 0;
            return b1 && b2;
        } else {
            BillingHistory billingHistory = BillingHistory.builder().id(billingHistory1.getId())
                    .electricityPrice(BigDecimal.valueOf(ePriceDouble))
                    .waterPrice(BigDecimal.valueOf(wPriceDouble))
                    .year(nextMonth.getYear())
                    .month(nextMonth.getMonthValue())
                    .build();
            boolean b2 = billingHistoryMapper.updateById(billingHistory) > 0;
            return b1 && b2;
        }
    }
}
