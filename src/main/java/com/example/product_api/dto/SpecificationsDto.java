package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecificationsDto {

	private String connectivity;
	private String battery_life;
	private String charging_time;
	private String weight;
	private DimensionsDto dimensions;
	private String driver_size;
	private String impedance;
}