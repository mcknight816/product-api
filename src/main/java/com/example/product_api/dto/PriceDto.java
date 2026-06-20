package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDto {

	private Double amount;
	private String currency;
	private Double compare_at_price;
	private Double discount_percentage;
}