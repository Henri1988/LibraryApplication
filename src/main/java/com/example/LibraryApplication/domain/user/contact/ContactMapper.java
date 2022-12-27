package com.example.LibraryApplication.domain.user.contact;

import com.example.LibraryApplication.service.register.RegisterRequest;
import com.example.LibraryApplication.service.register.RegisterResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    Contact contactDtoToContact(RegisterRequest request);

    @InheritInverseConfiguration(name = "contactDtoToContact")
    Contact contactToContactDto(RegisterResponse response);

    @InheritConfiguration(name = "contactDtoToContact")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact updateContactFromContactDto(RegisterRequest registerRequest, @MappingTarget Contact contact);
}
