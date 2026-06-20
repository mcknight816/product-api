package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorDto {

	private String name;
	private String hex_code;
	private Integer stock_quantity;
	private Boolean is_primary;
}