package com.itheima.article.controller;


import com.itheima.article.pojo.ApCollection;
import com.itheima.article.service.ApCollectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
* <p>
* APP收藏信息表 控制器</p>
* @author xh
* @since 2022-04-10
*/
@Api(value="APP收藏信息表",tags = "ApCollectionController")
@RestController
@RequestMapping("/apCollection")
public class ApCollectionController extends AbstractCoreController<ApCollection> {

    private ApCollectionService apCollectionService;

    //注入
    @Autowired
    public ApCollectionController(ApCollectionService apCollectionService) {
        super(apCollectionService);
        this.apCollectionService=apCollectionService;
    }

}

