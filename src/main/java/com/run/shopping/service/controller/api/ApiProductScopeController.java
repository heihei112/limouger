package com.run.shopping.service.controller.api;

import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.ProductSpecs;
import com.run.shopping.service.service.ProductSpecsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-specs")
@CrossOrigin
@Api(tags = "查询规格")
@Slf4j
public class ApiProductScopeController {

    @Autowired
    private ProductSpecsService productSpecsService;

    @ApiOperation("通过商品id查询所有规格")
    @GetMapping("getSpecs/{productId}")
    public R getSpecsList(@PathVariable("productId") String productId){
        List<ProductSpecs> productSpecs = productSpecsService.selectList(productId);
        return R.ok().data("items",productSpecs).message("规格查询成功");
    }
}
