package com.run.shopping.service.controller.admin;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.Product;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-08-01
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
@Api(tags = "商品管理")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("save")
    public R save(@RequestBody Product product){
        String productId =  productService.insert(product);
        return R.ok().data("productId",productId);
    }

    @GetMapping("getById/{productId}")
    public R getById(@PathVariable("productId") String productId){
        Product result = productService.getById(productId);
        if (result!=null) {
            return R.ok().data("item",result).message("数据回显成功");
        }
        return R.error().message("数据回显失败");
    }
    @PutMapping("update")
    public R update(@RequestBody Product product){
        productService.updateById(product);
        return R.ok().message("数据修改成功");
    }

    @PutMapping("updateStatus/{productId}")
    public  R updateStatus(@PathVariable("productId") String productId){
        productService.update(new UpdateWrapper<Product>().eq("id",productId).set("status",1));

        return R.ok().message("修改状态成功");
    }
    @ApiOperation("查询所有商品")
    @GetMapping("list/{page}/{limit}")
    public R saveList(@PathVariable("page") Long page, @PathVariable("limit") Long limit , ProductQueryVo productQueryVo){
        Page<ProductParamsVo> paramsVoPage = new Page<ProductParamsVo>(page,limit);
        IPage<ProductParamsVo> params =  productService.selectPage(paramsVoPage,productQueryVo);
        List<ProductParamsVo> records = params.getRecords();
        long total = params.getTotal();
        return R.ok().data("rows",records).data("total",total);
    }
    @DeleteMapping("delete/{productId}")
    public R removeList(@PathVariable("productId") String productId) {
        productService.deleteIds(productId);
        return R.ok().message("删除成功");
    }
}

