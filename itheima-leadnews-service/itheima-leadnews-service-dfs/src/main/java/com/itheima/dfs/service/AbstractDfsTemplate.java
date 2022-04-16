package com.itheima.dfs.service;

import com.itheima.dfs.pojo.DFSType;
import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractDfsTemplate implements IFileService, InitializingBean {


    // 1.创建连接对象 2.设置用户名和密码 3 创建客户端对象 4 ....连接到服务器 。。5.。。。  模拟 这个步骤

    //===============================


    //==============================



    /**
     * 定义支持的类型 必须设置值
     *
     * @return
     */
    public abstract DFSType support();

    //检查的 检查某一些条件是否达到了 达不到就报错 抛异常
    @Override
    public void afterPropertiesSet() throws Exception {
        //3个
        DFSType[] values = DFSType.values();

        boolean flag = false;
        for (DFSType value : values) {
            DFSType support = support();
            if(support==value){
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("不支持的dfs类型");
        }
    }
}