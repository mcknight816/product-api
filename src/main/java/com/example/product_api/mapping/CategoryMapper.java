package com.example.product_api.mapping;

import com.example.product_api.dto.CategoryDto;
import com.example.product_api.model.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper( CategoryMapper.class );

    Category categoryDtoToCategory(CategoryDto employeeDto);
    CategoryDto categoryToCategoryDto(Category employee);
}
