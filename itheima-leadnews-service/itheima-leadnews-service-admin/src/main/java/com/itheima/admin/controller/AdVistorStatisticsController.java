package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdVistorStatistics;
import com.itheima.admin.service.AdVistorStatisticsService;
import com.itheima.core.controller.AbstractCoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 访问数据统计表 控制器</p>
* @author ljh
* @since 2022-04-10
*/
@RestController
@RequestMapping("/adVistorStatistics")
public class AdVistorStatisticsController extends AbstractCoreController<AdVistorStatistics> {

    private AdVistorStatisticsService adVistorStatisticsService;

    //注入
    @Autowired
    public AdVistorStatisticsController(AdVistorStatisticsService adVistorStatisticsService) {
        super(adVistorStatisticsService);
        this.adVistorStatisticsService=adVistorStatisticsService;
    }

}

