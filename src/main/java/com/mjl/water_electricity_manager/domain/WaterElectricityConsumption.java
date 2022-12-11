package com.mjl.water_electricity_manager.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
    * 水电费消耗表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "water_electricity_consumption")
public class WaterElectricityConsumption {
    /**
     * 水电费消耗编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学校编号
     */
    @TableField(value = "school_id")
    private Integer schoolId;

    /**
     * 宿舍楼编号
     */
    @TableField(value = "dormitory_building_id")
    private Integer dormitoryBuildingId;

    /**
     * 宿舍编号
     */
    @TableField(value = "dormitory_id")
    private Integer dormitoryId;

    /**
     * 用水量
     */
    @TableField(value = "water_consume")
    private BigDecimal waterConsume;

    /**
     * 用电量
     */
    @TableField(value = "electricity_consume")
    private BigDecimal electricityConsume;

    /**
     * 水费
     */
    @TableField(value = "water_fee")
    private BigDecimal waterFee;

    /**
     * 电费
     */
    @TableField(value = "electricity_fee")
    private BigDecimal electricityFee;

    /**
     * 总费用
     */
    @TableField(value = "total_fee")
    private BigDecimal totalFee;

    /**
     * 记录时间
     */
    @TableField(value = "`date`")
    private Date date;

    public static final String COL_ID = "id";

    public static final String COL_SCHOOL_ID = "school_id";

    public static final String COL_DORMITORY_BUILDING_ID = "dormitory_building_id";

    public static final String COL_DORMITORY_ID = "dormitory_id";

    public static final String COL_WATER_CONSUME = "water_consume";

    public static final String COL_ELECTRICITY_CONSUME = "electricity_consume";

    public static final String COL_WATER_FEE = "water_fee";

    public static final String COL_ELECTRICITY_FEE = "electricity_fee";

    public static final String COL_TOTAL_FEE = "total_fee";

    public static final String COL_DATE = "date";
}