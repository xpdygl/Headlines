package com.itheima.media.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.pojo.Result;
import com.itheima.media.pojo.WmUser;
import com.itheima.media.service.WmUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import com.itheima.core.controller.AbstractCoreController;

import java.util.Map;

/**
* <p>
* 自媒体用户信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="自媒体用户信息表",tags = "WmUserController")
@RestController
@RequestMapping("/wmUser")
public class WmUserController extends AbstractCoreController<WmUser> {

    private WmUserService wmUserService;

    //注入
    @Autowired
    public WmUserController(WmUserService wmUserService) {
        super(wmUserService);
        this.wmUserService=wmUserService;
    }



     @GetMapping("/one/{apUserId}")
     public WmUser getByApUserId(@PathVariable(name="apUserId") Integer apUserId){
         //select * from xx where ap_user_id=?
         QueryWrapper<WmUser> querywrapper = new QueryWrapper<>();
         querywrapper.eq("ap_user_id",apUserId);
         return wmUserService.getOne(querywrapper);
     }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody WmUser wmUser) throws LeadNewsException {

        Map<String ,Object> info = wmUserService.login(wmUser);
        return Result.ok(info);
    }



}

