package com.test.platform.server.controller;

import com.test.platform.server.bean.FileBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjy on 17/2/15.
 */

@RequestMapping("/platform/project")
@RestController
@Api(value = "项目接口" , protocols = "JSON")
public class ProjectServer {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @ApiOperation(value = "演示接口" )
    @RequestMapping(value = "/demo" , method = RequestMethod.GET)
    public String demo(){
//        return  sqlSessionTemplate.selectOne("platform.mapper.demo");
        return new FileBean().getFilePath();
    }

    @ApiOperation(value = "增加项目接口" ,httpMethod = "POST")
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public boolean addProject(String projectName){

        return true;
    }



}
