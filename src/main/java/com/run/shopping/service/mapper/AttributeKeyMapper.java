package com.run.shopping.service.mapper;

import com.run.shopping.service.entity.AttributeKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.shopping.service.entity.vo.AttributeKeyVo;

import java.util.List;

/**
 * <p>
 * 属性key表 Mapper 接口
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
public interface AttributeKeyMapper extends BaseMapper<AttributeKey> {

    List<AttributeKeyVo> selectLists(String categoryId);
}
