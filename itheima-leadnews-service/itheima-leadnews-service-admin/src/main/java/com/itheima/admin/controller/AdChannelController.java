package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdChannel;
import com.itheima.admin.service.AdChannelService;
import com.itheima.core.controller.AbstractCoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 频道信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@RestController
@RequestMapping("/adChannel")
public class AdChannelController extends AbstractCoreController<AdChannel> {

    private AdChannelService adChannelService;

    //注入
    @Autowired
    public AdChannelController(AdChannelService adChannelService) {
        super(adChannelService);
        this.adChannelService=adChannelService;
    }

}

