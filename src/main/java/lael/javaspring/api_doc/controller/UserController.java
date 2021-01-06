package lael.javaspring.api_doc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lael.javaspring.api_doc.model.UserModel;

@RestController
@RequestMapping("/user")
@Api(value = "用户相关的API", description = "与用户相关的API")
public class UserController {

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录检测", notes = "根据用户名、密码判断该用户是否存在")
    @ApiResponses({ 
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
        @ApiResponse(code=400,message="请求参数没填好")
    })
    public UserModel login(
            @ApiParam(name = "account", value = "用户名", required = false) @RequestParam(value = "account", required = false) String account,
            @ApiParam(name = "password", value = "密码", required = false) @RequestParam(value = "password", required = false) String password) {
        return new UserModel(account, password);
    }
}
