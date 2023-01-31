package com.run.shopping.service.service.impl;

import com.alibaba.excel.event.Order;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.OrderDateils;
import com.run.shopping.service.entity.Orders;
import com.run.shopping.service.entity.vo.web.WebOrderParamVo;
import com.run.shopping.service.mapper.OrderDateilsMapper;
import com.run.shopping.service.mapper.OrderMapper;
import com.run.shopping.service.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-08-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {

    @Autowired
    private OrderDateilsMapper dateilsMapper;

    @Override
    @Transactional
    public String selectOrderId(Orders order) {
        baseMapper.insert(order);
        Orders orders = baseMapper.selectById(order);
        return  orders.getId();

    }

    @Override
    public List<WebOrderParamVo> selectOrderList(String id) {



        List<Orders> ordersList = baseMapper.selectList(new LambdaQueryWrapper<Orders>().eq(Orders::getUserId, id));
//        List<OrderDateils> orderDateil = new ArrayList<>();
        List<WebOrderParamVo> list = new ArrayList<>();

        ordersList.forEach(orders->{
            WebOrderParamVo paramVo = new WebOrderParamVo();
            paramVo.setOrderId(orders.getId());
            paramVo.setCreateTime(orders.getCreateTime());
            paramVo.setLinkman(orders.getLinkman());
            paramVo.setPrice(orders.getTotalPrice());
            paramVo.setStatus(orders.getStatus());
            List<OrderDateils> orderDateils = dateilsMapper.selectList(new LambdaQueryWrapper<OrderDateils>()
                    .eq(OrderDateils::getOrderId, orders.getId()));
            paramVo.setChildren(orderDateils);
            list.add(paramVo);
            System.out.println(list);
        });
        return  list;
    }

    @Override
    public List<WebOrderParamVo> selectList() {
        List<Orders> orderss = baseMapper.selectList(null);

        List<WebOrderParamVo> list = new ArrayList<>();

        orderss.forEach(orders->{
            WebOrderParamVo paramVo = new WebOrderParamVo();

            paramVo.setOrderId(orders.getId());
            paramVo.setCreateTime(orders.getCreateTime());
            paramVo.setLinkman(orders.getLinkman());
            paramVo.setPrice(orders.getTotalPrice());
            paramVo.setStatus(orders.getStatus());
            List<OrderDateils> orderDateils = dateilsMapper.selectList(new LambdaQueryWrapper<OrderDateils>()
                    .eq(OrderDateils::getOrderId, orders.getId()));
            paramVo.setChildren(orderDateils);
            list.add(paramVo);
            System.out.println(list);
        });

        return list;
    }

    @Override
    public void updateStatus(String orderId,String status) {
        UpdateWrapper<Orders> queryWrapper = new UpdateWrapper<>();
        queryWrapper.eq("id",orderId).set("status",status);
         baseMapper.update(null, queryWrapper);
    }

    @Override
    public IPage<WebOrderParamVo> selectPage(Page<WebOrderParamVo> pages) {

        return null;
    }
}
