package com.example.LibraryApplication.domain.member;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MemberMapper {
    @Mapping(target = "id", ignore = true)
    Member toEntity(MemberDto memberDto);

    MemberDto toDto(Member member);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Member updateEntity(MemberDto memberDto, @MappingTarget Member member);
}
