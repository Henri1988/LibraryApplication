package com.example.LibraryApplication.domain.user.contact;

import com.example.LibraryApplication.service.register.RegisterRequest;
import com.example.LibraryApplication.service.register.RegisterResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    Contact toEntity(RegisterRequest request);

    @InheritInverseConfiguration(name = "toEntity")
    Contact toDto(RegisterResponse response);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact updateEntity(RegisterRequest registerRequest, @MappingTarget Contact contact);
}
