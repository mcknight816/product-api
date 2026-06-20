package com.example.product_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleProductDto {

	private List<List<List<List<ImageDto>>>> images;
	private String description;
	private String created_at;
	private List<List<List<List<VariantDto>>>> variants;
	private InventoryDto inventory;
	private SpecificationsDto specifications;
	private List<List<List<List<ColorDto>>>> colors;
	private List<List<List<List<String>>>> tags;
	private ShippingDto shipping;
	private ReviewsDto reviews;
	private String updated_at;
	private PriceDto price;
	private String name;
	private String id;
	private List<List<List<List<CategoryDto>>>> categories;
	private String sku;
	private SeoDto seo;
	private String published_at;
	private String slug;
	private String status;
}