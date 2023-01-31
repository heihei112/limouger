package com.run.shopping.service.controller.admin;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.User;
import com.run.shopping.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/admin/user")
@CrossOrigin
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询接口
     * @return
     */
    @ApiOperation("查询所有用户接口")
    @GetMapping("list")
    public R list(){
        List<User> list = userService.list();
        return R.ok().data("list",list).message("查询所有用户");
    }

    @ApiOperation("分页查询")
    @GetMapping("pageSize/{page}/{limit}")
    public R pageList(@PathVariable("page") Long page , @PathVariable("limit") Long limit){
        Page<User> pageParam = new Page<>(page,limit);
        IPage<User> page1 = userService.page(pageParam);
        List<User> records = page1.getRecords();
        long total = page1.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public R save(@RequestBody User user) {
        userService.save(user);
        return R.ok().message("用户添加成功");
    }
    @ApiOperation("根据Id查询数据")
    @GetMapping("get/{id}")
    public R getById(@PathVariable String id){
        User byId = userService.getById(id);
        return R.ok().data("item",byId);
    }

    @ApiOperation("根据id修改数据")
    @PutMapping("update")
    public R updateById(@RequestBody User user){
        boolean result = userService.updateById(user);
        if (result){
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }

    @ApiOperation("根据id删除数据")
    @DeleteMapping("removeById/{id}")
    public R removeById(@PathVariable String id){
        userService.removeImgById(id);
        boolean result = userService.removeById(id);
        if (result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

}