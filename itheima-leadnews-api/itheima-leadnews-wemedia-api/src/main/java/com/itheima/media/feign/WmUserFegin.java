package com.itheima.media.feign;

import com.itheima.common.pojo.Result;
import com.itheima.core.feign.CoreFeign;
import com.itheima.media.pojo.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/WmUser")
@FeignClient(name = "leadnews-wemedia",path = "/wmUser")
public interface WmUserFegin extends CoreFeign<WmUser> {

//    @PostMapping
//    public Result<WmUser> save(@RequestBody WmUser wmUser);

    @GetMapping("/one/{apUserId}")
    public WmUser getByApUserId(@PathVariable( name = "apUserId") Integer apUserid);


}
