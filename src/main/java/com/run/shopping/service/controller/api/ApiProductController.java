package com.run.shopping.service.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.entity.vo.web.WebProductQueryVo;
import com.run.shopping.service.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="商品列表页")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/product")
@Slf4j
public class ApiProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("查询所有商品")
    @GetMapping("productList/{page}/{limit}")
    public R productList(@PathVariable("page") Long page, @PathVariable("limit") Long limit , WebProductQueryVo productQueryVo){
        Page<ProductParamsVo> paramsVoPage = new Page<>(page,limit);
        IPage<ProductParamsVo> pageParams = productService.selectPageList(paramsVoPage,productQueryVo);
        long total = pageParams.getTotal();
        List<ProductParamsVo> records = pageParams.getRecords();
        return R.ok().data("records",records).data("total",total);
    }
    @GetMapping("productIds/{productId}")
    public R productId(@PathVariable("productId") String productId){
        ProductParamsVo paramsVo =  productService.selectById(productId);
        return R.ok().data("item",paramsVo).message("获取商品成功");
    }
}
