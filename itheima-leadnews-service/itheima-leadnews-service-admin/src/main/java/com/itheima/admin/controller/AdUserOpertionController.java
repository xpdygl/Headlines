package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUserOpertion;
import com.itheima.admin.service.AdUserOpertionService;
import com.itheima.core.controller.AbstractCoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 管理员操作行为信息表 控制器</p>
* @author ljh
* @since 2022-04-10
*/
@RestController
@RequestMapping("/adUserOpertion")
public class AdUserOpertionController extends AbstractCoreController<AdUserOpertion> {

    private AdUserOpertionService adUserOpertionService;

    //注入
    @Autowired
    public AdUserOpertionController(AdUserOpertionService adUserOpertionService) {
        super(adUserOpertionService);
        this.adUserOpertionService=adUserOpertionService;
    }

}

