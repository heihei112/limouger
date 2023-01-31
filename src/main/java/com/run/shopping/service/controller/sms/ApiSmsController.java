package com.run.shopping.service.controller.sms;

import com.aliyuncs.exceptions.ClientException;

import com.run.shopping.model.utils.FormUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.model.utils.ResultCodeEnum;
import com.run.shopping.service.service.sms.SmsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
@Api(tags = "短信管理")
@CrossOrigin //跨域
@Slf4j
public class ApiSmsController {

    @Autowired
    private SmsService smsService;



    @GetMapping("send/{mobile}")
    public R getCode(@PathVariable String mobile) throws ClientException {
        System.out.println(mobile);
        //校验手机号是否合法
        if(StringUtils.isEmpty(mobile) || !FormUtils.isMobile(mobile)) {
            log.error("请输入正确的手机号码 ");
        }

        //发送验证码
        //将验证码存入redis缓存
        smsService.send(mobile);



        return R.ok().message("短信发送成功");
    }
}