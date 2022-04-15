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
 * 推荐策略信息表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_recommend_strategy")
public class AdRecommendStrategy implements Serializable {


    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 策略名称
     */
    @TableField("name")
    private String name;

    /**
     * 策略描述
     */
    @TableField("description")
    private String description;

    /**
     * 是否有效
     */
    @TableField("is_enable")
    private Integer isEnable;

    /**
     * 分组ID
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
