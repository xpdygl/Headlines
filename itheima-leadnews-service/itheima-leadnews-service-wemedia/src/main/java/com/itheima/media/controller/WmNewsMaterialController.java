package com.itheima.media.controller;


import com.itheima.media.pojo.WmNewsMaterial;
import com.itheima.media.service.WmNewsMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* 自媒体图文引用素材信息表  【暂时不用】 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="自媒体图文引用素材信息表  【暂时不用】",tags = "WmNewsMaterialController")
@RestController
@RequestMapping("/wmNewsMaterial")
public class WmNewsMaterialController extends AbstractCoreController<WmNewsMaterial> {

    private WmNewsMaterialService wmNewsMaterialService;

    //注入
    @Autowired
    public WmNewsMaterialController(WmNewsMaterialService wmNewsMaterialService) {
        super(wmNewsMaterialService);
        this.wmNewsMaterialService=wmNewsMaterialService;
    }

}

