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
 * 文章数据统计表
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_article_statistics")
public class AdArticleStatistics implements Serializable {


    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 主账号ID
     */
    @TableField("article_we_media")
    private Integer articleWeMedia;

    /**
     * 子账号ID
     */
    @TableField("article_crawlers")
    private Integer articleCrawlers;

    /**
     * 频道ID
     */
    @TableField("channel_id")
    private Integer channelId;

    /**
     * 草读量
     */
    @TableField("read_20")
    private Integer read20;

    /**
     * 读完量
     */
    @TableField("read_100")
    private Integer read100;

    /**
     * 阅读量
     */
    @TableField("read_count")
    private Integer readCount;

    /**
     * 评论量
     */
    @TableField("comment")
    private Integer comment;

    /**
     * 关注量
     */
    @TableField("follow")
    private Integer follow;

    /**
     * 收藏量
     */
    @TableField("collection")
    private Integer collection;

    /**
     * 转发量
     */
    @TableField("forward")
    private Integer forward;

    /**
     * 点赞量
     */
    @TableField("likes")
    private Integer likes;

    /**
     * 不喜欢
     */
    @TableField("unlikes")
    private Integer unlikes;

    /**
     * unfollow
     */
    @TableField("unfollow")
    private Integer unfollow;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;


}
