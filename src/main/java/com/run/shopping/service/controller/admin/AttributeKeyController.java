package com.run.shopping.service.controller.admin;


import com.run.shopping.model.utils.R;
import com.run.shopping.service.entity.AttributeKey;
import com.run.shopping.service.entity.AttributeValue;
import com.run.shopping.service.entity.vo.AttributeKeyVo;
import com.run.shopping.service.service.AttributeKeyService;
import com.run.shopping.service.service.AttributeValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性key表 前端控制器
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/admin/attribute-key")
@CrossOrigin
@Api(tags = "分类参数管理")
@Slf4j
public class AttributeKeyController {

    @Autowired
    public AttributeKeyService attributeKeyService ;

    @Autowired
    public AttributeValueService attributeValueService;

    @ApiOperation("查询所有属性")
    @GetMapping("list/{categoryId}")
    public R list(@PathVariable("categoryId") String categoryId){
      List<AttributeKeyVo> attributeList =  attributeKeyService.selectBykeyAndValue(categoryId);
      return R.ok().data("attributeList",attributeList);
    }

    @ApiOperation("添加属性")
    @PostMapping("save")
    public R saveKey(@RequestBody AttributeKey attributeKey){
        attributeKeyService.save(attributeKey);
        return R.ok().message("添加参数成功");
    }

    @ApiOperation("添加属性值")
    @PostMapping("saveValue")
    public R saveValue(@RequestBody AttributeValue attributeValue) {
        attributeValueService.save(attributeValue);
        return R.ok().message("添加参数值成功");
    }

}

