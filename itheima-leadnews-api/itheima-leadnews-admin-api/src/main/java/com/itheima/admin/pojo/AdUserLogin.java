package com.itheima.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员登录行为信息表
 * </p>
 *
 * @author ljh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_user_login")
public class AdUserLogin implements Serializable {


    @TableId("id")
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 登录设备ID
     */
    @TableField("equipment_id")
    private Integer equipmentId;

    /**
     * 登录IP
     */
    @TableField("ip")
    private String ip;

    /**
     * 登录地址
     */
    @TableField("address")
    private String address;

    /**
     * 经度
     */
    @TableField("longitude")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @TableField("latitude")
    private BigDecimal latitude;

    /**
     * 登录时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
