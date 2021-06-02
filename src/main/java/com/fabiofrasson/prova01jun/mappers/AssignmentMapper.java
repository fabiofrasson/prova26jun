package com.fabiofrasson.prova01jun.mappers;

import com.fabiofrasson.prova01jun.entities.Assignment;
import com.fabiofrasson.prova01jun.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AssignmentMapper {

  public static final AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

  public abstract Assignment toAssignment(Assignment assignment);
}
