package com.example.product_api.mapping;

import com.example.product_api.dto.SimpleProductDto;
import com.example.product_api.model.SimpleProduct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimpleProductMapper {
    SimpleProductMapper MAPPER = Mappers.getMapper( SimpleProductMapper.class );

    SimpleProduct simpleProductDtoToSimpleProduct(SimpleProductDto employeeDto);
    SimpleProductDto simpleProductToSimpleProductDto(SimpleProduct employee);
}
