package com.test.platform.server.controller;

import com.test.platform.server.bean.FileBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by zjy on 17/2/16.
 */

@RestController
@RequestMapping("/platform/case")
@Api(value = "用例管理接口" ,protocols = "JSON")
public class CaseServer {

    private Logger logger = LoggerFactory.getLogger(CaseServer.class);

    @ApiOperation(value = "导入用例接口", httpMethod = "POST")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public boolean importCasesForExcel(MultipartFile file){
        if (file.isEmpty()) {
            return false;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = new FileBean().getFilePath();
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        logger.info("create dir :" + filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();

        }
        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
