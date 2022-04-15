package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdArticleStatistics;
import com.itheima.admin.service.AdArticleStatisticsService;
import com.itheima.core.controller.AbstractCoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 文章数据统计表 控制器</p>
*/
@RestController
@RequestMapping("/adArticleStatistics")
public class AdArticleStatisticsController extends AbstractCoreController<AdArticleStatistics> {

    private AdArticleStatisticsService adArticleStatisticsService;

    //注入
    @Autowired
    public AdArticleStatisticsController(AdArticleStatisticsService adArticleStatisticsService) {
        super(adArticleStatisticsService);
        this.adArticleStatisticsService=adArticleStatisticsService;
    }

}

