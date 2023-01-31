package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.service.entity.AttributeValue;
import com.run.shopping.service.mapper.AttributeValueMapper;
import com.run.shopping.service.service.AttributeValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性value表 服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Service
public class AttributeValueServiceImpl extends ServiceImpl<AttributeValueMapper, AttributeValue> implements AttributeValueService {

    @Override
    public List<AttributeValue> attributeValues(String attributeValueId) {
        List<AttributeValue> list = baseMapper.selectList(new QueryWrapper<AttributeValue>().eq("attribute_id",attributeValueId));
        return list;
    }
}
