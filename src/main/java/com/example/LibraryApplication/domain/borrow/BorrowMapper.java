package com.example.LibraryApplication.domain.borrow;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BorrowMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "bookId", target = "book.id")
    Borrow toEntity(BorrowDto borrowDto);

    @InheritInverseConfiguration(name = "toEntity")
    BorrowDto borrowToBorrowDto(Borrow borrow);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Borrow updateBorrowFromBorrowDto(BorrowDto borrowDto, @MappingTarget Borrow borrow);
}
