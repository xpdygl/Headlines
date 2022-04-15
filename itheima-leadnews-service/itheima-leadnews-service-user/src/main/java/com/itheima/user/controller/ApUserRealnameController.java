package com.itheima.user.controller;


import com.itheima.common.pojo.Result;
import com.itheima.user.pojo.ApUserRealname;
import com.itheima.user.service.ApUserRealnameService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import com.itheima.core.controller.AbstractCoreController;

import java.util.Map;

/**
* <p>
* APP实名认证信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="APP实名认证信息表",tags = "ApUserRealnameController")
@RestController
@RequestMapping("/apUserRealname")
public class ApUserRealnameController extends AbstractCoreController<ApUserRealname> {

    private ApUserRealnameService apUserRealnameService;

    //注入
    @Autowired
    public ApUserRealnameController(ApUserRealnameService apUserRealnameService) {
        super(apUserRealnameService);
        this.apUserRealnameService=apUserRealnameService;
    }

    @PutMapping("/pass/{id}")
    public Result pass(@PathVariable(name="id") Integer id){
        apUserRealnameService.pass(id);
        return Result.ok();
    }

    @PutMapping("/reject/{id}")
    public Result reject(@PathVariable(name="id") Integer id,@RequestParam(name="reason") String reason){
        apUserRealnameService.reject(id,reason);
        return Result.ok();
    }
}

