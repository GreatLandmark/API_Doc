package lael.javaspring.api_doc.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lael.javaspring.api_doc.service.OcrService;
/**
* Copyright © 2021 LaeL group. All rights reserved.
* @FileName: TestController2
* @author: Lofit
* @QQ: 3210175940
* @Email: greatlandmark@outlook.com
* @Date: 2021-01-05 
* @version 1.0.0
* @Description: 用于练习，很多@注解 都是可选的。@Api**是用于文档说明的。
* \
* develop.md文件有详细的参考教程。
*/
@RestController
@RequestMapping("/test")
@Api("Test API")
public class TestController2 {
    /**
    * 
    * @author: Lofit
    * @see: Author Email : greatlandmark@outlook.com
    * @param {*} 
    * @return
    * @reference  https://blog.csdn.net/qq_36826506/article/details/82182817 
    */
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="header",name="username",dataType="string",required=true,value="用户的姓名",defaultValue="lofit"),
        @ApiImplicitParam(paramType="query",name="password",dataType="string",required=true,value="用户的密码",defaultValue="tifol"),
    })
    @ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/getUser",method=RequestMethod.GET)
    public String getUser(@RequestHeader("username") String username, @RequestParam("password") String password) {
        return username+"\n"+password+"\n";
    }

    @ApiImplicitParams({
        @ApiImplicitParam(paramType="header",name="username",dataType="string",required=true,value="用户的姓名",defaultValue="lofit"),
        @ApiImplicitParam(paramType="query",name="password",dataType="string",required=true,value="用户的密码",defaultValue="tifol"),
        @ApiImplicitParam(paramType="body",name="text",dataType="string",required=true,value="用户的描述",defaultValue="LaeL"),
    })
    @PostMapping("/getUserPostBody")
    public String getUserPostBody(@RequestHeader("username") String username, @RequestParam("password") String password,
    @RequestBody String text){
        return username+"\n"+password+"\n"+text+"\n";
    }

    @ApiImplicitParams({
        @ApiImplicitParam(paramType="header",name="username",dataType="string",required=true,value="用户的姓名",defaultValue="lofit"),
        @ApiImplicitParam(paramType="query",name="password",dataType="string",required=true,value="用户的密码",defaultValue="tifol"),
        @ApiImplicitParam(paramType="form",name="email",dataType="string",required=true,value="用户的电子邮箱",defaultValue="lofit@lael.fun"),
        @ApiImplicitParam(paramType="form",name="email2",dataType="string",required=true,value="用户的电子邮箱",defaultValue="lofit2@lael.fun")
    })
    // 请求内容类型应该是application/x-www-form-urlencoded，但是在UI中CURL参数出错，注意。
    @PostMapping("/getUserPostForm")
    public String getUserPostForm(@RequestHeader("username") String username, @RequestParam("password") String password,@RequestParam String email,@RequestParam String email2){
        return username+"\n"+password+"\n"+email+"\n"+email2;
    }

    @Autowired
    private OcrService ocrService;
    @GetMapping("/ocr")
    public String ocr(){
        return ocrService.test1();
    }
}
