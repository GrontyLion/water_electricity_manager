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
    * 用户表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User {
    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 用户类型
     */
    @TableField(value = "user_type_id")
    private Integer userTypeId;

    /**
     * 性别（M：男，F：女）
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 邮箱号码
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 宿舍编号
     */
    @TableField(value = "dormitory_id")
    private Integer dormitoryId;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_USER_TYPE_ID = "user_type_id";

    public static final String COL_GENDER = "gender";

    public static final String COL_AGE = "age";

    public static final String COL_EMAIL = "email";

    public static final String COL_PHONE = "phone";

    public static final String COL_PASSWORD = "password";

    public static final String COL_DORMITORY_ID = "dormitory_id";
}