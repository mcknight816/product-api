package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class SimpleProduct {

	private List<List<List<List<List<List<Image>>>>>> images;
	private String description;
	private String created_at;
	private List<List<List<List<List<List<Variant>>>>>> variants;
	private Inventory inventory;
	private Specifications specifications;
	private List<List<List<List<List<List<Color>>>>>> colors;
	private List<List<List<List<List<List<String>>>>>> tags;
	private Shipping shipping;
	private Reviews reviews;
	private String updated_at;
	private Price price;
	private String name;
	@Id
	private String id;
	private List<List<List<List<List<List<Category>>>>>> categories;
	private String sku;
	private Seo seo;
	private String published_at;
	private String slug;
	private String status;
}