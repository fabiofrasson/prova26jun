package com.fabiofrasson.prova01jun.mappers;

import com.fabiofrasson.prova01jun.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer toCustomer(Customer customer);
}
