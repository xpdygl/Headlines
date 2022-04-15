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
 * 角色权限信息表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_role_auth")
public class AdRoleAuth implements Serializable {


    @TableId("id")
    private Integer id;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 资源类型	            0 菜单	            1 功能
     */
    @TableField("type")
    private Integer type;

    /**
     * 资源ID
     */
    @TableField("entry_id")
    private Integer entryId;

    /**
     * 登录时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
