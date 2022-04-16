package com.itheima.media.controller;


import com.itheima.common.pojo.PageInfo;
import com.itheima.common.pojo.PageRequestDto;
import com.itheima.common.pojo.Result;
import com.itheima.media.dto.WmNewsDto;
import com.itheima.media.dto.WmNewsDtoSave;
import com.itheima.media.pojo.WmNews;
import com.itheima.media.service.WmNewsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* 自媒体图文内容信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="自媒体图文内容信息表",tags = "WmNewsController")
@RestController
@RequestMapping("/wmNews")
public class WmNewsController extends AbstractCoreController<WmNews> {

    private WmNewsService wmNewsService;

    //注入
    @Autowired
    public WmNewsController(WmNewsService wmNewsService) {
        super(wmNewsService);
        this.wmNewsService=wmNewsService;
    }

    @PostMapping("/searchPage")
    public Result<PageInfo<WmNews>> findByPageDto(@RequestBody PageRequestDto<WmNewsDto> pageRequestDto){
        PageInfo<WmNews> pageInfo = wmNewsService.findByPageDto(pageRequestDto);
        return Result.ok(pageInfo);
    }

    //保存自媒体文章 保存草稿 和 添加 或者修改
    @PostMapping("/save/{isSubmit}")
    public Result save(@PathVariable(name="isSubmit") Integer isSubmit,@RequestBody WmNewsDtoSave wmNewsDtoSave){
        if(StringUtils.isEmpty(isSubmit) || wmNewsDtoSave==null){
            return Result.errorMessage("数据不能为空");
        }
        if(isSubmit>1 || isSubmit<0){
            return Result.errorMessage("isSubmit的值有误");
        }
        wmNewsService.save(wmNewsDtoSave,isSubmit);
        return Result.ok();
    }
}

