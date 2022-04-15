package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserInfo;
import com.itheima.user.service.ApUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* APP用户信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="APP用户信息表",tags = "ApUserInfoController")
@RestController
@RequestMapping("/apUserInfo")
public class ApUserInfoController extends AbstractCoreController<ApUserInfo> {

    private ApUserInfoService apUserInfoService;

    //注入
    @Autowired
    public ApUserInfoController(ApUserInfoService apUserInfoService) {
        super(apUserInfoService);
        this.apUserInfoService=apUserInfoService;
    }

}

