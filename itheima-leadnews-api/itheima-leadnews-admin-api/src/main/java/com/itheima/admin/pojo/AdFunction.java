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
 * 页面功能信息表
 * </p>
 *
 * @author ljh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_function")
public class AdFunction implements Serializable {


    @TableId("id")
    private Integer id;

    /**
     * 功能名称
     */
    @TableField("name")
    private String name;

    /**
     * 功能代码
     */
    @TableField("code")
    private String code;

    /**
     * 父功能
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 登录时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
