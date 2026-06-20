package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto {

	private String id;
	private String url;
	private String alt_text;
	private Integer position;
	private Boolean is_primary;
}