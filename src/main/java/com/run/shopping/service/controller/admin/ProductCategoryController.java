package com.run.shopping.service.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.ProductCategory;
import com.run.shopping.service.entity.vo.ProductCategoryVo;
import com.run.shopping.service.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/admin/product-category")
@CrossOrigin
@Api(tags = "分类管理")
@Slf4j
public class ProductCategoryController {


    @Autowired
    private ProductCategoryService productCategoryService;


    @ApiOperation(value = "Excel批量导入商品类别数据")
    @PostMapping("import")
    public R batchImport(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            productCategoryService.batchImport(inputStream);
            return R.ok().message("批量导入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.error().message("导入失败");
    }

    @ApiOperation("分页查询")
    @GetMapping("pageSize/{page}/{limit}")
    public R pageList(@PathVariable("page") Long page , @PathVariable("limit") Long limit,  String title){
        Page<ProductCategoryVo> pageParam = new Page<ProductCategoryVo>(page,limit);
        IPage<ProductCategoryVo> param = productCategoryService.selectPage(pageParam,title);
        long total = param.getTotal();
        List<ProductCategoryVo> records = param.getRecords();
        return R.ok().data("total",total).data("records",records);

    }


    @ApiOperation("查询所有分类")
    @GetMapping("list")
    public R categoryList(){
       List<ProductCategoryVo> categoryList =  productCategoryService.categoryList();

       return R.ok().data("items",categoryList);
    }

    @ApiOperation("添加一级分类")
    @PostMapping("save")
    public R saveOne(@RequestBody ProductCategory productCategory){

        productCategoryService.save(productCategory);
        return R.ok().message("添加分类成功");
    }


    @DeleteMapping("remove/{categoryId}")
    public R removeByTwo(@PathVariable("categoryId") String categoryId){
        productCategoryService.removeById(categoryId);
        return R.ok().message("删除二级分类成功");
    }

    @DeleteMapping("removeOne/{categoryId}")
    public R removeByOntAndTwoList(@PathVariable("categoryId") String categoryId){
        productCategoryService.removeByOne(categoryId);
        return R.ok().message("删除一级分类成功");
    }

    @ApiOperation("修改二级分类")
    @PutMapping("updateByTwo")
    public R updateByTwo(@RequestBody ProductCategory productCategory){
        productCategoryService.updateById(productCategory);
        return R.ok().message("修改二级分类成功");
    }
    @ApiOperation("修改一级分类成功")
    @PutMapping("updateByOne")
    public R updateByOne(@RequestBody ProductCategory productCategory){
        productCategoryService.updateById(productCategory);
        return R.ok().message("修改一级分类成功");
    }

    @GetMapping("get/{id}")
    public R getById(@PathVariable String id){
        ProductCategory byId = productCategoryService.getById(id);
        return R.ok().data("item",byId).message("查询成功");
    }



}

