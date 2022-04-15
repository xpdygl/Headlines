package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdSensitive;
import com.itheima.admin.service.AdSensitiveService;
import com.itheima.core.controller.AbstractCoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 敏感词信息表 控制器</p>
* @author ljh
* @since 2022-04-10
*/
@RestController
@RequestMapping("/adSensitive")
public class AdSensitiveController extends AbstractCoreController<AdSensitive> {

    private AdSensitiveService adSensitiveService;

    //注入
    @Autowired
    public AdSensitiveController(AdSensitiveService adSensitiveService) {
        super(adSensitiveService);
        this.adSensitiveService=adSensitiveService;
    }

}

