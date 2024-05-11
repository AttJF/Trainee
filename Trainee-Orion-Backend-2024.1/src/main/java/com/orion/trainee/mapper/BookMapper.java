package com.orion.trainee.mapper;

import com.orion.trainee.dto.BookDto;
import com.orion.trainee.model.Book;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toEntity(BookDto bookDto);

    BookDto toDto(Book book);
}