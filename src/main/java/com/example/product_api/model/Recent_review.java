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
public class Recent_review {

	@Id
	private String id;
	private Integer rating;
	private String title;
	private String content;
	private String author;
	private Boolean verified_purchase;
	private String created_at;
}