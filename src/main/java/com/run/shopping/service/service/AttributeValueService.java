package com.run.shopping.service.service;

import com.run.shopping.service.entity.AttributeValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 属性value表 服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
public interface AttributeValueService extends IService<AttributeValue> {

    List<AttributeValue> attributeValues(String attributeValueId);
}
