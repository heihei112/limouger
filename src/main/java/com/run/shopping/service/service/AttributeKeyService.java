package com.run.shopping.service.service;

import com.run.shopping.service.entity.AttributeKey;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.AttributeKeyVo;

import java.util.List;

/**
 * <p>
 * 属性key表 服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
public interface AttributeKeyService extends IService<AttributeKey> {


    List<AttributeKeyVo> selectBykeyAndValue(String categoryId);
}
