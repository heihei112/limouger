package com.run.shopping.service.service.impl;

import com.run.shopping.service.entity.ShoppingCart;
import com.run.shopping.service.entity.vo.web.WebShoppingParamVo;
import com.run.shopping.service.mapper.ShoppingCartMapper;
import com.run.shopping.service.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-08-15
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    @Override
    public List<WebShoppingParamVo> getShoppingCart(String userId) {
        return baseMapper.selectCartList(userId);
    }
}
