package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.service.entity.AttributeKey;
import com.run.shopping.service.entity.AttributeValue;
import com.run.shopping.service.entity.vo.AttributeKeyVo;
import com.run.shopping.service.mapper.AttributeKeyMapper;
import com.run.shopping.service.mapper.AttributeValueMapper;
import com.run.shopping.service.service.AttributeKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.shopping.service.service.AttributeValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 属性key表 服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Service
public class AttributeKeyServiceImpl extends ServiceImpl<AttributeKeyMapper, AttributeKey> implements AttributeKeyService {

    @Autowired
    private AttributeValueService attributeValueService;

    @Override
    public List<AttributeKeyVo> selectBykeyAndValue(String categoryId) {

        List<AttributeKey> attributes = this.list(new QueryWrapper<AttributeKey>()
                .eq("category_id", categoryId));

       List<AttributeKeyVo> collect = attributes.stream().map(group->{
            AttributeKeyVo attributeKeyVo = new AttributeKeyVo();
            BeanUtils.copyProperties(group,attributeKeyVo);
            List<AttributeValue> attributeValues = attributeValueService.attributeValues(group.getId());
            attributeKeyVo.setChildren(attributeValues);
            System.out.println(attributeKeyVo);
            return attributeKeyVo;
        }).collect(Collectors.toList());

        return collect;

        //        List<AttributeKeyVo>  vo = new ArrayList<>();
//        for (AttributeKey attribute : attributes) {
//            AttributeKeyVo attributeKeyVo = new AttributeKeyVo();
//            BeanUtils.copyProperties(attribute,attributeKeyVo);
//            System.out.println(attribute.getId());
//            List<AttributeValue> attributeValues = attributeValueService.attributeValues(attribute.getId());
//            attributeKeyVo.setChildren(attributeValues);
//            System.out.println(attributeKeyVo);
//        }
//        return null;
    }
}
