package com.itheima.article.feign;


import com.itheima.article.pojo.ApAuthor;
import com.itheima.common.pojo.Result;
import com.itheima.core.feign.CoreFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/apAuthor")

@FeignClient(name="leadnews-article",path = "/apAuthor")

public interface ApAuthorFeign extends CoreFeign<ApAuthor> {

//    @PostMapping
//    public Result<ApAuthor> save(@RequestBody ApAuthor apAuthor);




    /**
     * 根据APP用户的ID 获取 作者信息
     * @param apUserId
     * @return
     */
    @GetMapping("/one/{apUserId}")
    public ApAuthor getByApUserId(@PathVariable(name="apUserId")Integer apUserId);
}
