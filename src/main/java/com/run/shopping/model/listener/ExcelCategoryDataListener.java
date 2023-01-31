package com.run.shopping.model.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.model.excel.ExcelCategoryData;
import com.run.shopping.service.entity.ProductCategory;
import com.run.shopping.service.mapper.ProductCategoryMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ExcelCategoryDataListener extends AnalysisEventListener<ExcelCategoryData> {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void invoke(ExcelCategoryData data, AnalysisContext context) {
        //处理读取出来的数据
        // 一级标题
        String levelOneTitle = data.getLevelOneTitle();
        // 二级标题
        String levelTwoTitle = data.getLevelTwoTitle();

        ProductCategory categoryOne = this.getByTitle(levelOneTitle,"0");
        String parentId = null;
        if (categoryOne == null) {
            // 将一级分类存进数据库
            ProductCategory category = new ProductCategory();
            category.setParentId("0");
            // 一级分类名称
            category.setTitle(levelOneTitle);
            productCategoryMapper.insert(category);
            parentId = category.getId();
        } else {
            parentId = categoryOne.getId();
        }
        // 判断二级分类是否重复
        ProductCategory catByTowTitle = this.getByTitle(levelTwoTitle, parentId);
        if (catByTowTitle == null) {
            ProductCategory category = new ProductCategory();
            category.setTitle(levelTwoTitle);
            category.setParentId(parentId);
            // 添加
            productCategoryMapper.insert(category);
        }


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    /**
     * 根据分类名称查询这个一级分类是否存在
     * @param title
     * @return
     */
    private ProductCategory getByTitle(String title, String parentId) {
        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<ProductCategory>()
         .eq("title",title)
        // 一级分类Id
        .eq("parent_id",parentId);
        return productCategoryMapper.selectOne(queryWrapper);
    }

}
