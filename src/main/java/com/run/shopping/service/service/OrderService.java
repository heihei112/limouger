package com.run.shopping.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.web.WebOrderParamVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-08-17
 */
public interface OrderService extends IService<Orders> {

    String  selectOrderId(Orders order);

    List<WebOrderParamVo> selectOrderList(String id);

    List<WebOrderParamVo> selectList();

    void updateStatus(String orderId,String status);

    IPage<WebOrderParamVo> selectPage(Page<WebOrderParamVo> pages);
}
