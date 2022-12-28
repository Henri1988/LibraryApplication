package com.example.LibraryApplication.domain.borrow;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BorrowMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userUserName", target = "user.userName")
    @Mapping(source = "userPassword", target = "user.password")
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookAuthor", target = "book.author")
    @Mapping(source = "bookReleaseTime", target = "book.releaseTime")
    @Mapping(source = "bookGenre", target = "book.genre")
    @Mapping(source = "bookLendingPeriod", target = "book.lendingPeriod")
    @Mapping(source = "bookLocation", target = "book.location")
    @Mapping(source = "bookQuantity", target = "book.quantity")
    @Mapping(target = "id", ignore = true)
    Borrow toEntity(BorrowDto borrowDto);

    @InheritInverseConfiguration(name = "toEntity")
    BorrowDto toDto(Borrow borrow);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Borrow updateEntity(BorrowDto borrowDto, @MappingTarget Borrow borrow);
}
