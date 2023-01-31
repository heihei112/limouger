package com.run.shopping.service.controller.api;

import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.vo.LoginVo;
import com.run.shopping.service.entity.vo.RegisterVo;
import com.run.shopping.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="用户登录")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/login")
@Slf4j
public class ApiLoginController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("register")
    public R  register(@RequestBody RegisterVo registerVo) {
        userService.register(registerVo);
        return R.ok().message("添加成功");
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public R login(@RequestBody LoginVo loginVo) {
       String token = userService.login(loginVo);
       return R.ok().data("token",token);
    }


}
