package com.run.shopping.service.service.impl;

import com.run.shopping.service.entity.Orders;
import com.run.shopping.service.mapper.OrdersMapper;
import com.run.shopping.service.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
