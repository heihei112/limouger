package com.run.shopping.service.controller.api;


import com.run.shopping.model.utils.JwtInfo;
import com.run.shopping.model.utils.JwtUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.UserAddress;
import com.run.shopping.service.service.UserAddressService;
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
 * @since 2022-07-25
 */
@Api(tags="用户地址管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/address")
@Slf4j
public class ApiUserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("list")
    public R selectList(HttpServletRequest request){

        JwtInfo info = JwtUtils.getMemberIdByJwtToken(request);

        List<UserAddress> addrList = userAddressService.selectList(info.getId());

       return R.ok().data("items",addrList).message("查询成功");
    }

    @PostMapping("save")
    public R save(@RequestBody UserAddress userAddress) {
        userAddressService.save(userAddress);
        return R.ok().message("添加成功");
    }

    @GetMapping("getById/{id}")
    public R getById(@PathVariable("id") String id){
        UserAddress byId = userAddressService.getById(id);
        return R.ok().data("item",byId).message("查询成功");
    }

    @DeleteMapping("remove/{id}")
    public R removeById(@PathVariable("id") String id) {
        boolean remove = userAddressService.removeById(id);
        return remove ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @PutMapping("update")
    public R update(@RequestBody UserAddress userAddress){
        boolean b = userAddressService.updateById(userAddress);
        return b ? R.ok().message("修改成功") : R.error().message("修改失败");
    }

}

