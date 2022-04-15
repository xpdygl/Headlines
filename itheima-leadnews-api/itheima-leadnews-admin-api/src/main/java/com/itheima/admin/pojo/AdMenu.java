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
 * 菜单资源信息表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_menu")
public class AdMenu implements Serializable {


    @TableId("id")
    private Integer id;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * 菜单代码
     */
    @TableField("code")
    private String code;

    /**
     * 父菜单
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 登录时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
