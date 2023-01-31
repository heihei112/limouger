package com.run.shopping.service.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.ProductSpecs;
import com.run.shopping.service.service.ProductSpecsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 规格表 前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/admin/product-specs")
@CrossOrigin
@Api(tags = "添加规格")
@Slf4j
public class ProductSpecsController {

    @Autowired
    private ProductSpecsService productSpecsService;

    @PostMapping("save")
    public R save(@RequestBody ProductSpecs productSpecs){
        productSpecsService.save(productSpecs);
        return R.ok().message("添加成功");
    }

    @GetMapping("getById/{productId}")
    public R getBySpecs(@PathVariable("productId") String productId){
        List<ProductSpecs> productList =  productSpecsService.selectList(productId);
        return R.ok().data("items",productList);
    }

    @PutMapping("update")
    public R updateSpecs(@RequestBody ProductSpecs productSpecs){
        boolean b = productSpecsService.updateById(productSpecs);
        if (b) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }

}

