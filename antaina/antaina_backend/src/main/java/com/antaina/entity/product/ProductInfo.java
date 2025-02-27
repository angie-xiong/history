package com.antaina.entity.product;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

@Data
public class ProductInfo {

	@Id
	private Long id;

	/**
	 * 物料编号
	 */
	@ApiModelProperty(value = "物料编号")
	private String productCode;

	/**
	 * 物料名称
	 */
	@ApiModelProperty(value = "物料名称")
	private String productName;

	/**
	 * 型号
	 */
	@ApiModelProperty(value = "型号")
	private String model;

	/**
	 * 计量单位
	 */
	@ApiModelProperty(value = "计量单位")
	private Integer productUnit;

	/**
	 * 物料类型(0:原料; 1:半成品; 2:成品)
	 */
	@ApiModelProperty(value = "物料类型(0:原料; 1:半成品; 2:成品)")
	private Integer type;

	private java.util.Date createTime;

	private java.util.Date updateTime;


}
