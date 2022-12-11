package com.mjl.water_electricity_manager.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 宿舍表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dormitory")
public class Dormitory {
    /**
     * 宿舍编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宿舍名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 宿舍容纳人数
     */
    @TableField(value = "capacity")
    private Integer capacity;

    /**
     * 宿舍已入住人数
     */
    @TableField(value = "occupied")
    private Integer occupied;

    /**
     * 宿舍楼编号
     */
    @TableField(value = "dormitory_building_id")
    private Integer dormitoryBuildingId;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_CAPACITY = "capacity";

    public static final String COL_OCCUPIED = "occupied";

    public static final String COL_DORMITORY_BUILDING_ID = "dormitory_building_id";
}