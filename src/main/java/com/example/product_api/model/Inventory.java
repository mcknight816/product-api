package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

	private Integer quantity;
	private Boolean track_inventory;
	private Boolean allow_backorder;
	private String warehouse_location;
}