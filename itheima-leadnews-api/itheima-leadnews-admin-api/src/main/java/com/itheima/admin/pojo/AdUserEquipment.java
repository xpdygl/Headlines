package com.itheima.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员设备信息表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_user_equipment")
public class AdUserEquipment implements Serializable {


    @TableId("id")
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 0PC	            1ANDROID	            2IOS	            3PAD	            9 其他
     */
    @TableField("type")
    private Integer type;

    /**
     * 设备版本
     */
    @TableField("version")
    private String version;

    /**
     * 设备系统
     */
    @TableField("sys")
    private String sys;

    /**
     * 设备唯一号，MD5加密
     */
    @TableField("no")
    private String no;

    /**
     * 登录时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
