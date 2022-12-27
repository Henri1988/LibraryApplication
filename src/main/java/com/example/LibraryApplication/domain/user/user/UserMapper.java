package com.example.LibraryApplication.domain.user.user;

import com.example.LibraryApplication.service.register.RegisterRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toEntity(RegisterRequest request);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateEntity(UserDto userDto, @MappingTarget User user);
}
