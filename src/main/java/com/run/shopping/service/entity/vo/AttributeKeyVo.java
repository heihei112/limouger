package com.run.shopping.service.entity.vo;

import com.run.shopping.service.entity.AttributeKey;
import com.run.shopping.service.entity.AttributeValue;
import lombok.Data;

import java.util.List;

@Data
public class AttributeKeyVo {

    private String id;
    private String categoryId;
    private String attributeName;

    private List<AttributeValue> children;

}
