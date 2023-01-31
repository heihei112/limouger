package com.run.shopping.service.controller.admin;


import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.AttributeValue;
import com.run.shopping.service.entity.vo.AttributeKeyVo;
import com.run.shopping.service.service.AttributeValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性value表 前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/admin/attribute-value")
@CrossOrigin
@Api(tags = "分类参数管理")
@Slf4j
public class AttributeValueController {

    @Autowired
    private AttributeValueService attributeValueService;

    @ApiOperation("查询所有属性")
    @GetMapping("list/{categoryId}")
    public R list(@PathVariable("categoryId") String categoryId){
        List<AttributeValue> attributeList =  attributeValueService.attributeValues(categoryId);
        return R.ok().data("attributeList",attributeList);
    }
}

