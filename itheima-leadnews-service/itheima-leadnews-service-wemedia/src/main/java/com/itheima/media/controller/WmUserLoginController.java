package com.itheima.media.controller;


import com.itheima.media.pojo.WmUserLogin;
import com.itheima.media.service.WmUserLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* 自媒体用户登录行为信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="自媒体用户登录行为信息表",tags = "WmUserLoginController")
@RestController
@RequestMapping("/wmUserLogin")
public class WmUserLoginController extends AbstractCoreController<WmUserLogin> {

    private WmUserLoginService wmUserLoginService;

    //注入
    @Autowired
    public WmUserLoginController(WmUserLoginService wmUserLoginService) {
        super(wmUserLoginService);
        this.wmUserLoginService=wmUserLoginService;
    }

}

