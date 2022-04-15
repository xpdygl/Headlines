package com.itheima.dfs.conteoller;


import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.itheima.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/dfs")
@RestController
public class FileController {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;


    @Autowired
    private FdfsWebServer fdfsWebServer;

    @PostMapping("/upload")
    public Result<Map<String,String>> upload (MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();

        long fileSize = file.getSize();

        String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());
        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, fileSize, extName, null);

        String fullPath = storePath.getFullPath();
        String realUrl = fdfsWebServer.getWebServerUrl()+fullPath;
        Map<String,String> map = new HashMap<String,String>();
        map.put("url",realUrl);
        //设置返回图片的路径
        return Result.ok(map);
    }
}
