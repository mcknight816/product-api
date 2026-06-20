package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {

	private Integer quantity;
	private Boolean track_inventory;
	private Boolean allow_backorder;
	private String warehouse_location;
}