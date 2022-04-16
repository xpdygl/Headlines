package com.itheima.dfs.controller;

import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.itheima.common.pojo.Result;
import com.itheima.dfs.pojo.BaseFileModel;
import com.itheima.dfs.pojo.DFSType;
import com.itheima.dfs.service.IFileService;
import com.itheima.dfs.strategy.FileServiceStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dfs")
public class FileController {


   /* @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;*/


    /**
     * 图片上传
     *
     * @param file 文件本身
     * @return
     */
   /* @PostMapping("/upload")
    public Result<Map<String, String>> upload(MultipartFile file) throws Exception {
        //1.获取相关参数

        //1.1 获取流对象
        InputStream inpustream = file.getInputStream();
        //1.2 获取文件的大小
        long fileSize = file.getSize();

        //1.3 获取扩展名
        String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());
        //2.使用fdfs的client 将其上传给fdfs服务器即可
        StorePath storePath = fastFileStorageClient.uploadFile(inpustream, fileSize, extName, null);
        //3.返回一个URL以及其他参数
        Map<String, String> resultMap = new HashMap<>();
        // url  =     http://192.168.211.136/group1/M00/00/00/wKjTiGJVT4WAfOunAAAvRohVIrE190.jpg
        //路径应该是使用域名合适 而且上线一定会使用【域名】
        String realPath = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
        resultMap.put("url", realPath);
        return Result.ok(resultMap);
    }*/

/*
    @Autowired
    @Qualifier(value="ossFileTemplate")//根据bean名字获取
    private IFileService iFileService;
*/

    @Autowired
    private FileServiceStrategyContext context;

    @Value("${fdfs.type}")
    private String type;

    @PostMapping("/upload")
    public Result<Map<String, String>> upload(MultipartFile file) throws Exception {

        Map<String,String> map = new HashMap<>();
        if(!file.isEmpty()){
            BaseFileModel fileModel = new BaseFileModel(
                    //这里应该是当前登录的用户的ID对应的用户名
                    "zhangsan",
                    file.getSize(),
                    file.getOriginalFilename(),
                    file.getBytes()//文件本身的字节数组
            );
            IFileService iFileService = context.getIFleService(DFSType.valueOf(type));
            String path = iFileService.uploadFile(fileModel);
            map.put("url",path);
            return Result.ok(map);
        }
        return Result.errorMessage("错误");
    }


}
