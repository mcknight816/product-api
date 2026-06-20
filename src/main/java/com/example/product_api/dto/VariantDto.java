package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariantDto {

	private String id;
	private String color;
	private String sku_suffix;
	private Integer price_adjustment;
}