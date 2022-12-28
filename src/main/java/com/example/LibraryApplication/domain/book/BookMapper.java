package com.example.LibraryApplication.domain.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDto bookDto);

    BookDto toDto(Book book);

    List<BookDto> toDtos(List<Book>books);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}
