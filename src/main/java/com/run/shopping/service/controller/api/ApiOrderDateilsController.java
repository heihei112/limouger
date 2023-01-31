package com.run.shopping.service.controller.api;


import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.OrderDateils;
import com.run.shopping.service.service.OrderDateilsService;
import com.run.shopping.service.service.ShoppingCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-08-17
 */
@Api(tags="添加订单详情")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/orderDateils")
@Slf4j
public class ApiOrderDateilsController {

    @Autowired
    private OrderDateilsService orderDateilsService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("saveOrderdetails")
    public R save(@RequestBody OrderDateils orderDateils) {
        System.out.println(orderDateils);
        boolean save = orderDateilsService.save(orderDateils);
        if (save){
            return R.ok().message("添加订单详情成功");
        } else {
            return R.error().message("添加详情失败");
        }
    }
}

