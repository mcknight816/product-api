package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingDto {

	private Double weight;
	private String weight_unit;
	private String ships_from;
	private Integer estimated_delivery_days;
}