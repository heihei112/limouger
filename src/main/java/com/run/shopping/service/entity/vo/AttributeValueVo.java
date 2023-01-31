package com.run.shopping.service.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttributeValueVo {

    private String vid;
    private String attributeId;
    private String attributeValue;

}
