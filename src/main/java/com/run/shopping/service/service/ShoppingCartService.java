package com.run.shopping.service.service;

import com.run.shopping.service.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.web.WebShoppingParamVo;

import java.util.List;

/**
 * <p>
 * 购物车  服务类
 * </p>
 *
 * @author limou
 * @since 2022-08-15
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    List<WebShoppingParamVo> getShoppingCart(String userId);
}
