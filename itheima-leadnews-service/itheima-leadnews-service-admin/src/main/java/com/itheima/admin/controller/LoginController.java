package com.itheima.admin.controller;

import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.service.AdUserService;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/admin")
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private AdUserService adUserService;

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody AdUser adUser) throws LeadNewsException {

        Map<String ,Object> info = adUserService.login(adUser);
        return Result.ok(info);
    }


}
