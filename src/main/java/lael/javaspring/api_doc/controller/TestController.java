package lael.javaspring.api_doc.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
* Copyright © 2021 LaeL group. All rights reserved.
* @FileName: TestController
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
// @Api(tags = {"test","LaeLLofit"})
public class TestController {
    private final String hello="hello java";
    @GetMapping("/")
    @ApiOperation(value = "Test类的根目录", notes = "这是Test类的根目录\"/\"",httpMethod="GET")
    public String root(){
        return "{Class: TestController,Name: Test}";
    }
    @GetMapping("/id/{id}")
    @ApiOperation(value = "参数id", notes = "有参数")
    // @ApiImplicitParam(name = "id",value = "Long类型的id",example ="1234",defaultValue = "0")
    public String id(@PathVariable Long id){
        return "{Class: TestController,Name: Test,Data:{id: "+id+"}}";
    }
    @GetMapping("/name/{name}")
    @ApiOperation(value = "参数name", notes = "有参数")
    @ApiImplicitParam(name = "name",value = "String类型的name",example ="Lofit",defaultValue = "lofit")
    public String name(@PathVariable String name){
        return "{Class: TestController,\nName: Test,\nData:{name: "+name+"}}";
    }
    //多参数：在路径中
    @GetMapping("/class/{clasz}/gender/{gender}/isOK/{isOK}")
    @ApiOperation(value = "多参数：class,gender,isOK", notes = "有多个参数")
    @ApiImplicitParams({@ApiImplicitParam(name = "clasz",value = "班级Class",example ="Class2",defaultValue = "Class1"),
    @ApiImplicitParam(name = "gender",value = "String类型的gender",example ="Female",defaultValue = "Male")})
    public String clasz3(@PathVariable String clasz,@PathVariable String gender,@PathVariable Boolean isOK){
        return "{Class: TestController,\nName: Test,\nData:{class: "+clasz+", gender: "+gender+", isOK: "+isOK+"}}";
    }
    @PostMapping("/class/{clasz}/gender/{gender}")
    @ApiOperation(value = "多参数：class,gender,x,y", notes = "有多个参数")
    @ApiImplicitParams({@ApiImplicitParam(name = "clasz",value = "班级Class",example ="Class2",defaultValue = "Class1"),
    @ApiImplicitParam(name = "gender",value = "String类型的gender",example ="Female",defaultValue = "Male")})
    public String clasz3(@RequestParam Integer x,@PathVariable String clasz,@PathVariable String gender,@RequestParam float y){
        return "{Class: TestController,\nName: Test,\nData:{class: "+clasz+", gender: "+gender+"x: "+x+", y: "+y+"}}";
    }
    //多参数：？参数格式
    @GetMapping("/centerPonit")
    @ApiOperation(value = "多参数：(x,y), ?查询式")
    @ApiImplicitParams({@ApiImplicitParam(name = "x",value = "x",example ="33.33",defaultValue = "1.1"),
    @ApiImplicitParam(name = "y",value = "y",example ="5.5",defaultValue = "2.2")})
    public String hello(@RequestParam Double x,@RequestParam Float y){
        return "{Class: TestController,\nName: Test,\nCenterPoint:{x: "+x+", y: "+y+"}}";
    }
    //仅供练习的，不具有真实性。
    @RequestMapping(value="/delete/{id}/{name}",method={RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
    public String delete(@PathVariable Integer id,@PathVariable("name") String username){
        return "person:{id: "+id+ ", username: " + username+" }";
    }    
}
