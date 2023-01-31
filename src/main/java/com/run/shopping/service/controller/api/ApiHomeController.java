package com.run.shopping.service.controller.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.exception.ShoppingException;
import com.run.shopping.model.utils.JwtInfo;
import com.run.shopping.model.utils.JwtUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.model.utils.ResultCodeEnum;
import com.run.shopping.service.entity.Ad;
import com.run.shopping.service.entity.vo.ProductCategoryVo;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.service.AdService;
import com.run.shopping.service.service.ProductCategoryService;
import com.run.shopping.service.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags="首页展示区域")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/home")
@Slf4j
public class ApiHomeController {

    @Autowired
    private AdService adService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @ApiOperation("查询所有轮播图信息")
    @GetMapping("list")
    public R list(){

        List<Ad> list = adService.list(new QueryWrapper<Ad>().eq("status",0));
        return R.ok().data("items",list);
    }

    @ApiOperation("查询分类信息")
    @GetMapping("categoryList")
    public R categoryList(){
        List<ProductCategoryVo> productCategoryVos = productCategoryService.categoryList();
        return R.ok().data("items",productCategoryVos);
    }

    @ApiOperation("查询所有商品")
    @GetMapping("productList/{page}/{limit}")
    public R productList(@PathVariable("page") Long page, @PathVariable("limit") Long limit , ProductQueryVo productQueryVo){
        Page<ProductParamsVo> paramsVoPage = new Page<ProductParamsVo>(page,limit);
        IPage<ProductParamsVo> params =  productService.selectPage(paramsVoPage,productQueryVo);
        List<ProductParamsVo> records = params.getRecords();
        long total = params.getTotal();
        return R.ok().data("rows",records).data("total",total);
    }
    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("get-login-info")
    public R getLoginInfo(HttpServletRequest request){

        try{
            JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
            return R.ok().data("userInfo", jwtInfo);
        }catch (Exception e){
            log.error("解析用户信息失败，" + e.getMessage());
            throw new ShoppingException(ResultCodeEnum.FETCH_USERINFO_ERROR);
        }
    }
}
