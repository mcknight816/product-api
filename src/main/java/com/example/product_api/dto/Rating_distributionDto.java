package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating_distributionDto {

	private Integer _5_star;
	private Integer _4_star;
	private Integer _3_star;
	private Integer _2_star;
	private Integer _1_star;
}