package com.mjl.water_electricity_manager.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 历史计费标准
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "billing_history")
public class BillingHistory {
    /**
     * 历史计费编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宿舍楼编号
     */
    @TableField(value = "dormitory_building_id")
    private Integer dormitoryBuildingId;

    /**
     * 水费单价
     */
    @TableField(value = "water_price")
    private BigDecimal waterPrice;

    /**
     * 电费单价
     */
    @TableField(value = "electricity_price")
    private BigDecimal electricityPrice;

    /**
     * 年份
     */
    @TableField(value = "`year`")
    private Integer year;

    /**
     * 月份
     */
    @TableField(value = "`month`")
    private Integer month;

    public static final String COL_ID = "id";

    public static final String COL_DORMITORY_BUILDING_ID = "dormitory_building_id";

    public static final String COL_WATER_PRICE = "water_price";

    public static final String COL_ELECTRICITY_PRICE = "electricity_price";

    public static final String COL_YEAR = "year";

    public static final String COL_MONTH = "month";
}