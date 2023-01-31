package com.run.shopping.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelCategoryData {

    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;
}
