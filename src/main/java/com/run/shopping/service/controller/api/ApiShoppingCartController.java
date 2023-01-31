package com.run.shopping.service.controller.api;


import com.run.shopping.model.utils.JwtInfo;
import com.run.shopping.model.utils.JwtUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.ShoppingCart;
import com.run.shopping.service.entity.vo.web.WebShoppingParamVo;
import com.run.shopping.service.service.ShoppingCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 购物车  前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/api/shopping-cart")
@CrossOrigin
@Api(tags = "购物车管理")
@Slf4j
public class ApiShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService ;

    @PostMapping("save")
    public R saveCart(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.save(shoppingCart);
        return R.ok().message("添加购物车成功");
    }

    @GetMapping("list")
    public R cartList(HttpServletRequest request) {
        JwtInfo jwtinfo = JwtUtils.getMemberIdByJwtToken(request);
        List<WebShoppingParamVo> cartList = shoppingCartService.getShoppingCart(jwtinfo.getId());
        return R.ok().data("cartList",cartList);
    }

    @PutMapping("updateNum")
    public R update(@RequestBody ShoppingCart shoppingCart){
        boolean b = shoppingCartService.updateById(shoppingCart);
        return b ? R.ok().message("修改成功") : R.error().message("修改失败");
    }

    @DeleteMapping("remove/{cartId}")
    public R remove(@PathVariable("cartId") String cartId){
        boolean remove = shoppingCartService.removeById(cartId);
        return remove ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @DeleteMapping("deletes")
    public R removeIds(@RequestBody List<ShoppingCart> shoppingCart) {
        shoppingCart.forEach(param -> {
            shoppingCartService.removeById(param.getId());
        });
        return R.ok().message("删除成功");
    }
}

