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
 * 访问数据统计表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_vistor_statistics")
public class AdVistorStatistics implements Serializable {


    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 日活
     */
    @TableField("activity")
    private Integer activity;

    /**
     * 访问量
     */
    @TableField("vistor")
    private Integer vistor;

    /**
     * IP量
     */
    @TableField("ip")
    private Integer ip;

    /**
     * 注册量
     */
    @TableField("register")
    private Integer register;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
