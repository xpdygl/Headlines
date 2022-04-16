package com.itheima.media.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.common.pojo.PageInfo;
import com.itheima.common.pojo.PageRequestDto;
import com.itheima.common.util.RequestContextUtil;
import com.itheima.media.dto.ContentNode;
import com.itheima.media.dto.WmNewsDto;
import com.itheima.media.dto.WmNewsDtoSave;
import com.itheima.media.pojo.WmNews;
import com.itheima.media.mapper.WmNewsMapper;
import com.itheima.media.service.WmNewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 自媒体图文内容信息表 服务实现类
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Service
public class WmNewsServiceImpl extends ServiceImpl<WmNewsMapper, WmNews> implements WmNewsService {

    @Autowired
    private WmNewsMapper wmNewsMapper;
    
    @Override
    public PageInfo<WmNews> findByPageDto(PageRequestDto<WmNewsDto> pageRequestDto) {
        //select * from xxx where ... limit 0..10
        Long size = pageRequestDto.getSize();
        Long page = pageRequestDto.getPage();
        WmNewsDto body = pageRequestDto.getBody();

        IPage<WmNews> pageConditon = null;
        QueryWrapper<WmNews> queryWrapper = null;
        if (body!=null) {
            pageConditon = new Page<>(size,page);
            queryWrapper = new QueryWrapper<>();
            if(!StringUtils.isEmpty(                body.getStatus())){
            queryWrapper.eq("status",        body.getStatus());
            }
            if (!StringUtils.isEmpty(body.getTitle())) {
                queryWrapper.like("title",   body.getTitle());
            }
            if (!StringUtils.isEmpty(body.getChannelId())) {
                queryWrapper.eq("channel_id", body.getChannelId());
            }
            if (!StringUtils.isEmpty(body.getStartTime()) || !StringUtils.isEmpty(body.getEndTime())) {
                queryWrapper.between("publish_time", body.getStartTime(), body.getEndTime());
            }
        }


        //核心 执行分页查询
        IPage<WmNews> wmNewsIPage = wmNewsMapper.selectPage(pageConditon, queryWrapper);

        return new PageInfo<WmNews>(
                wmNewsIPage.getCurrent(),
                wmNewsIPage.getSize(),
                wmNewsIPage.getTotal(),
                wmNewsIPage.getTotal(),
                wmNewsIPage.getRecords()
        );
    }

    @Override
    public void save(WmNewsDtoSave wmNewsDtoSave, Integer isSubmit) {
        //执行关键语句
        //填充条件
        //从传进来的参数拷贝进去
        //还有不够的手动set

        WmNews entity = new WmNews();
        BeanUtils.copyProperties(wmNewsDtoSave,entity);
        entity.setUserId(Integer.valueOf(RequestContextUtil.getUserInfo()));
        List<ContentNode> content = wmNewsDtoSave.getContent();
        entity.setContent(JSON.toJSONString(content));
        //判断图片
        //如果是自动图  则判断 图文内容中的图片有多少张，如果是>2 则为多图 如果是1 则为单图 如果是小于1 则为 无图
        //设置封面图片 将list 转成一个以逗号分隔的字符串
        if (wmNewsDtoSave.getImages() != null && wmNewsDtoSave.getImages().size() > 0) {
            entity.setImages(String.join(",", wmNewsDtoSave.getImages()));
        }

        if (entity.getType() == -1) {
            List<String> imagesFromContent = getImagesFromContent(wmNewsDtoSave);
            //说明是多图
            if (imagesFromContent.size() > 2) {
                //设置为多图
                entity.setType(3);
                //并设置图片 因为页面没有传递了
                entity.setImages(String.join(",", imagesFromContent));
            } else if (imagesFromContent.size() > 0 && imagesFromContent.size() <= 2) {
                //设置为单图
                entity.setType(1);
                //设置图片为一张
                entity.setImages(imagesFromContent.get(0));
            } else {
                //无图
                entity.setType(0);
                //空字符串
                entity.setImages("");
            }

        }

        //保存草稿或者提交审核
        entity.setStatus(isSubmit);
        if (isSubmit == 1) {
            entity.setSubmitedTime(LocalDateTime.now());
        }
        //修改数据
        if (wmNewsDtoSave.getId() != null) {
            wmNewsMapper.updateById(entity);
        } else {
            //添加数据
            entity.setCreatedTime(LocalDateTime.now());
            wmNewsMapper.insert(entity);
        }

        wmNewsMapper.insert(entity);

    }


    //获取图片路径列表
    private List<String> getImagesFromContent(WmNewsDtoSave wmNewsDtoSave) {
        List<ContentNode> content = wmNewsDtoSave.getContent();
        List<String> images = new ArrayList<String>();
        for (ContentNode contentNode : content) {
            //图片
            if (contentNode.getType().equals("image")) {
                String value = contentNode.getValue();
                images.add(value);
            }
        }
        return images;
    }
}
