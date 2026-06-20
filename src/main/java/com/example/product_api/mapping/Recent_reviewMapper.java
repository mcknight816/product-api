package com.example.product_api.mapping;

import com.example.product_api.dto.Recent_reviewDto;
import com.example.product_api.model.Recent_review;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Recent_reviewMapper {
    Recent_reviewMapper MAPPER = Mappers.getMapper( Recent_reviewMapper.class );

    Recent_review recentReviewDtoToRecent_review(Recent_reviewDto employeeDto);
    Recent_reviewDto recentReviewToRecent_reviewDto(Recent_review employee);
}
