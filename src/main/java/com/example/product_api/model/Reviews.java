package com.example.product_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reviews {

	private Double average_rating;
	private Integer total_reviews;
	private Rating_distribution rating_distribution;
	private List<Recent_review> recent_reviews;
}