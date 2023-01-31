package com.run.shopping.service.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.Ad;
import com.run.shopping.service.service.AdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 广告推荐 前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/admin/ad")
@CrossOrigin
@Api(tags = "轮播图管理")
@Slf4j
public class AdController {

    @Autowired
    private AdService adService;

    @ApiOperation("查询所有轮播图")
    @GetMapping("list")
    public R list() {
        QueryWrapper<Ad> qw = new QueryWrapper<>();
        qw.orderByAsc("sort");
        List<Ad> list = adService.list(qw);
        return R.ok().data("items",list);
    }

    @ApiOperation("添加轮播图")
    @PostMapping("insert")
    public R insert(@RequestBody Ad ad){
        boolean save = adService.save(ad);
        if (save){
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

    @ApiOperation("查询单个轮播图")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable("id") String id) {
        Ad byId = adService.getById(id);
        return R.ok().data("item",byId).message("查询成功");
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable("id") String id){
        adService.removeById(id);
        return R.ok().message("删除成功");
    }
    @ApiOperation("修改轮播图")
    @PutMapping("update")
    public R update(@RequestBody Ad ad){
        adService.updateById(ad);
        return R.ok().message("修改成功");
    }

    @ApiOperation("轮播图下架")
    @PutMapping("updateStatus/{adId}/{status}")
    public R updateStatus(@PathVariable("adId") String adId, @PathVariable("status") Integer status){
        adService.update(new UpdateWrapper<Ad>().eq("id",adId).set("status", status));

        return status == 0 ?  R.ok().message("上线成功") : R.error().message("失败");
    }
}

