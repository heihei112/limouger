package com.run.shopping.service.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.model.excel.ExcelCategoryData;
import com.run.shopping.model.listener.ExcelCategoryDataListener;
import com.run.shopping.service.entity.ProductCategory;
import com.run.shopping.service.entity.vo.ProductCategoryVo;
import com.run.shopping.service.mapper.ProductCategoryMapper;
import com.run.shopping.service.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

import static javafx.beans.binding.Bindings.select;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {


    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelCategoryData.class,new ExcelCategoryDataListener(baseMapper)).excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }

    @Override
    public List<ProductCategoryVo> categoryList() {

        return baseMapper.selectByCategoryOneAndTwo("0");
    }

    @Override
    public void removeByOne(String categoryId) {
        baseMapper.deleteById(categoryId);

        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<ProductCategory>()
                                        .select("parent_id")
                                        .eq("parent_id",categoryId);

        baseMapper.delete(queryWrapper);
    }

    @Override
    public IPage<ProductCategoryVo> selectPage(Page<ProductCategoryVo> pageParam, String title) {
        // 封装查询条件
        QueryWrapper<ProductCategoryVo> queryWrapper = new QueryWrapper<>();

        // 判断标题是否为空
        if (!StringUtils.isEmpty(title)){
            queryWrapper.like("title",title);
        }

        List<ProductCategoryVo> recodes =  baseMapper.selectByPageCateGory(pageParam,"0");

        pageParam.setRecords(recodes);
        return pageParam;
    }
}
