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

	private List<Image> images;
	private String description;
	private String created_at;
	private List<Variant> variants;
	private Inventory inventory;
	private Specifications specifications;
	private List<Color> colors;
	private List<String> tags;
	private Shipping shipping;
	private Reviews reviews;
	private String updated_at;
	private Price price;
	private String name;
	@Id
	private String id;
	private List<Category> categories;
	private String sku;
	private Seo seo;
	private String published_at;
	private String slug;
	private String status;
}