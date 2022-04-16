package com.itheima.media.controller;


import com.itheima.common.pojo.Result;
import com.itheima.common.util.RequestContextUtil;
import com.itheima.media.pojo.WmMaterial;
import com.itheima.media.service.WmMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

import java.time.LocalDateTime;

/**
* <p>
* 自媒体图文素材信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="自媒体图文素材信息表",tags = "WmMaterialController")
@RestController
@RequestMapping("/wmMaterial")
public class WmMaterialController extends AbstractCoreController<WmMaterial> {

    private WmMaterialService wmMaterialService;

    //注入
    @Autowired
    public WmMaterialController(WmMaterialService wmMaterialService) {
        super(wmMaterialService);
        this.wmMaterialService=wmMaterialService;
    }

    @Override
    public Result<WmMaterial> insert(WmMaterial record) {
        //1.设置补充属性
        //todo 先硬编码 设置为该素材所属的自媒体账号ID
        String userId = RequestContextUtil.getUserInfo();
        record.setUserId(Integer.parseInt(userId));
        record.setCreatedTime(LocalDateTime.now());
        record.setType(0);
        record.setIsCollection(0);
        return Result.ok();
    }
}

