package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserArticleList;
import com.itheima.user.service.ApUserArticleListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* APP用户文章列表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="APP用户文章列表",tags = "ApUserArticleListController")
@RestController
@RequestMapping("/apUserArticleList")
public class ApUserArticleListController extends AbstractCoreController<ApUserArticleList> {

    private ApUserArticleListService apUserArticleListService;

    //注入
    @Autowired
    public ApUserArticleListController(ApUserArticleListService apUserArticleListService) {
        super(apUserArticleListService);
        this.apUserArticleListService=apUserArticleListService;
    }

}

