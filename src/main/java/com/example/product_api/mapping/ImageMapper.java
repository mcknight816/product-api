package com.example.product_api.mapping;

import com.example.product_api.dto.ImageDto;
import com.example.product_api.model.Image;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {
    ImageMapper MAPPER = Mappers.getMapper( ImageMapper.class );

    Image imageDtoToImage(ImageDto employeeDto);
    ImageDto imageToImageDto(Image employee);
}
