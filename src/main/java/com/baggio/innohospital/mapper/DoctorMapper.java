package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.dto.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DepartmentMapper mapper = Mappers.getMapper(DepartmentMapper.class);

    Doctor toDoctor(DoctorDto doctorDto);

    DoctorDto toDoctorDto(Doctor doctor);

}
