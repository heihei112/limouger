package com.run.shopping.service.controller.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.utils.JwtInfo;
import com.run.shopping.model.utils.JwtUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.Orders;
import com.run.shopping.service.entity.ProductSpecs;
import com.run.shopping.service.entity.vo.web.WebOrderParamVo;
import com.run.shopping.service.entity.vo.web.WebSetStockParamVo;
import com.run.shopping.service.service.OrderService;
import com.run.shopping.service.service.ProductSpecsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-08-17
 */
@Api(tags="添加订单")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/order")
@Slf4j
public class ApiOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductSpecsService specsService;

    @PostMapping("saveOrder")
    public R save(@RequestBody Orders order) {
       String orderId = orderService.selectOrderId(order);
        return R.ok().message("添加订单成功").data("orderId",orderId);
    }

    @GetMapping("orderList")
    public R list(HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        List<WebOrderParamVo> order = orderService.selectOrderList(jwtInfo.getId());
        return R.ok().data("items",order).message("查询订单成功");
    }

    @GetMapping("list")
    public R getList(){
        List<WebOrderParamVo> list = orderService.selectList();
        return R.ok().data("items",list).message("提示信息");
    }

    @PutMapping("status/{orderId}/{status}")
    public R setStatus(@PathVariable("orderId") String orderId,@PathVariable("status") String status) {
        orderService.updateStatus(orderId,status);
        return  R.ok().message("修改成功");
    }

    @PutMapping("upStock")
    public R upStock(@RequestBody List<WebSetStockParamVo> stockParamVo){

        stockParamVo.forEach(stock -> {
            Integer cartNum = stock.getCartNum();
            String productSpecsId = stock.getProductSpecsId();

            ProductSpecs specs = specsService.getById(productSpecsId);
            Integer num = specs.getProductStock()-cartNum;
            UpdateWrapper<ProductSpecs> queryWrapper = new UpdateWrapper<>();
            queryWrapper.eq("id",productSpecsId).set("product_stock",num);

            specsService.update(null,queryWrapper);
        });

        return R.ok().message("修改库存成功");
    }
}

