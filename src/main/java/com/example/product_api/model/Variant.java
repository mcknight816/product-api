package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Variant {

	@Id
	private String id;
	private String color;
	private String sku_suffix;
	private Integer price_adjustment;
}