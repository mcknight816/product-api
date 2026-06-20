package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specifications {

	private String connectivity;
	private String battery_life;
	private String charging_time;
	private String weight;
	private Dimensions dimensions;
	private String driver_size;
	private String impedance;
}