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
    * 学校信息表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "school_info")
public class SchoolInfo {
    /**
     * 学校编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学校名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 学校地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 学校电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 学校邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 学校网址
     */
    @TableField(value = "website")
    private String website;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_ADDRESS = "address";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_WEBSITE = "website";
}