package com.run.shopping.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.run.shopping.service.entity.UserCollection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
public interface UserCollectionMapper extends BaseMapper<UserCollection> {

    @Select("SELECT p.id as productid,\tp.name as productName, p.attribute_list as attributeList,\n" +
            "p.main_img as productImg, p.buy_count as buyCount,p.sku_img as productImgList,\n" +
            "p.introduce as productIntroduce,p.category_id as categoryId,p.status as status,\n" +
            "ps.id as productSpecsId,ps.product_specs as productSpecs,ps.product_stock as productStock,\n" +
            "ps.product_price as productPrice \n" +
            "FROM user as u LEFT JOIN user_collection as uc \n" +
            "on  u.id = uc.user_id LEFT JOIN product as p \n" +
            "on  uc.product_id = p.id LEFT JOIN product_specs as ps\n" +
            "on  p.id = ps.product_id\n" +
            "WHERE u.id = #{userId}\n" +
            "GROUP BY p.name")
    List<ProductParamsVo> selectUserList(IPage<ProductParamsVo> pageParam, String userId);
}
