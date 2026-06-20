package com.example.product_api.mapping;

import com.example.product_api.dto.VariantDto;
import com.example.product_api.model.Variant;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VariantMapper {
    VariantMapper MAPPER = Mappers.getMapper( VariantMapper.class );

    Variant variantDtoToVariant(VariantDto employeeDto);
    VariantDto variantToVariantDto(Variant employee);
}
