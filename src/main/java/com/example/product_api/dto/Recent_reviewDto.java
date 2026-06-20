package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recent_reviewDto {

	private String id;
	private Integer rating;
	private String title;
	private String content;
	private String author;
	private Boolean verified_purchase;
	private String created_at;
}