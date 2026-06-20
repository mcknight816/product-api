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
public class ReviewsDto {

	private Double average_rating;
	private Integer total_reviews;
	private Rating_distributionDto rating_distribution;
	private List<List<List<List<Recent_reviewDto>>>> recent_reviews;
}