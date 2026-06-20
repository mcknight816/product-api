package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

	private Double amount;
	private String currency;
	private Double compare_at_price;
	private Double discount_percentage;
}