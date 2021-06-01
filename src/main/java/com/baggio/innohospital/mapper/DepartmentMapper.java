package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface DepartmentMapper {

    DepartmentMapper Instance = Mappers.getMapper(DepartmentMapper.class);

    Department toDepartment(DepartmentDto departmentDto);

    DepartmentDto toDepartmentDto(Department department);

}
