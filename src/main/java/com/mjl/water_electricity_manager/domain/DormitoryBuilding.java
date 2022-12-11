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
    * 宿舍楼信息表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dormitory_building")
public class DormitoryBuilding {
    /**
     * 宿舍楼编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学校编号
     */
    @TableField(value = "school_id")
    private Integer schoolId;

    /**
     * 宿舍楼名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 总宿舍数
     */
    @TableField(value = "total_room_number")
    private Integer totalRoomNumber;

    /**
     * 已入住宿舍数
     */
    @TableField(value = "occupied_room_number")
    private Integer occupiedRoomNumber;

    /**
     * 总容纳人数
     */
    @TableField(value = "total_capacity")
    private Integer totalCapacity;

    /**
     * 已入住人数
     */
    @TableField(value = "occupied_capacity")
    private Integer occupiedCapacity;

    /**
     * 宿舍楼管理员姓名
     */
    @TableField(value = "leader_name")
    private String leaderName;

    /**
     * 宿舍楼管理员电话
     */
    @TableField(value = "leader_phone")
    private String leaderPhone;

    /**
     * 宿舍楼管理员邮箱
     */
    @TableField(value = "leader_email")
    private String leaderEmail;

    public static final String COL_ID = "id";

    public static final String COL_SCHOOL_ID = "school_id";

    public static final String COL_NAME = "name";

    public static final String COL_TOTAL_ROOM_NUMBER = "total_room_number";

    public static final String COL_OCCUPIED_ROOM_NUMBER = "occupied_room_number";

    public static final String COL_TOTAL_CAPACITY = "total_capacity";

    public static final String COL_OCCUPIED_CAPACITY = "occupied_capacity";

    public static final String COL_LEADER_NAME = "leader_name";

    public static final String COL_LEADER_PHONE = "leader_phone";

    public static final String COL_LEADER_EMAIL = "leader_email";
}