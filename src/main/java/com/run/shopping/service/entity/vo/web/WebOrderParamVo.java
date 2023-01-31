package com.run.shopping.service.entity.vo.web;

import com.run.shopping.service.entity.OrderDateils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class WebOrderParamVo {

    private String id;
    private String orderId;
    private Date createTime;
    private String linkman;
    private BigDecimal price;
    private Integer status;
    private List<OrderDateils> children = new ArrayList<>();
}
