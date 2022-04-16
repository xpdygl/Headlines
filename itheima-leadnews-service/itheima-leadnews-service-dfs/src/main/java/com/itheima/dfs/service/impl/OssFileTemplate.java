package com.itheima.dfs.service.impl;

import com.itheima.dfs.pojo.BaseFileModel;
import com.itheima.dfs.pojo.DFSType;
import com.itheima.dfs.service.AbstractDfsTemplate;
import com.itheima.dfs.service.IFileService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OssFileTemplate extends AbstractDfsTemplate implements IFileService {
    ///oss的逻辑
    @Override
    public String uploadFile(BaseFileModel fileModel) {
        // 1.创建连接对象 2.设置用户名和密码 3 创建客户端对象 4 ....连接到服务器 。。5.。。。  模拟 这个步骤

        //6 使用oss的API来实现文件上传 模拟

        return null;
    }

    @Override
    public boolean delete(String fullPath) {

        return false;
    }

    @Override
    public List<byte[]> download(List<String> fullPath) {
        return null;
    }

    @Override
    public DFSType support() {
        return DFSType.OSSDFS;
    }
}
