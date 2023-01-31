package com.run.shopping.service.controller.api;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.controller.admin.UserController;
import com.run.shopping.service.entity.UserCollection;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.service.UserCollectionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
@Api(tags="用户收藏商品")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/user-collection")
public class ApiUserCollectionController {

    @Autowired
    private UserCollectionService  userCollectionService;

    @GetMapping("list/{userId}/{page}/{limit}")
    public R list(@PathVariable("userId") String userId,@PathVariable("page") Long page,@PathVariable("limit") Long limit ){
        Page<ProductParamsVo> param = new Page<ProductParamsVo>(page,limit);

        IPage<ProductParamsVo> items =  userCollectionService.selectList(param,userId);

        return R.ok().data("items",items);
    }

    @PostMapping("save")
    public R list(@RequestBody UserCollection userCollection){
        boolean save = userCollectionService.insertColl(userCollection);
        if (save){
            return R.ok().data("item",save).message("添加成功");
        } else {
            return R.ok().data("item",save).message("取消收藏成功");
        }
    }

    @GetMapping("getId/{productId}")
    public R selectById(@PathVariable("productId") String productId){
        LambdaQueryWrapper<UserCollection> queryWrapper  = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCollection::getProductId,productId);
        UserCollection byId = userCollectionService.getOne(queryWrapper);
        if (Objects.isNull(byId)){
            return R.ok().data("item",false).message("没收藏");
        }else {
            return R.ok().data("item",true).message("收藏了");
        }
//        return  Objects.isNull(byId) ? R.ok().data("item",true).message("没收藏")
//                :R.ok().data("item",false).message("收藏了");
    }

}

