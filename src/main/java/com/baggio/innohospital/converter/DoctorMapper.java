package com.baggio.innohospital.converter;

import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorMapper {

    private final DepartmentMapper departmentMapper;

    public Doctor toDoctor(DoctorDto doctorDto){
        if ( doctorDto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDto.getId() );
        doctor.setName( doctorDto.getName() );
        doctor.setEmail( doctorDto.getEmail() );
        doctor.setDob( doctorDto.getDob() );
        doctor.setDepartment(departmentMapper.toDepartment(doctorDto.getDepartmentDto()));
        return doctor;
    }

    public DoctorDto toDoctorDto(Doctor doctor){
        if ( doctor == null ) {
            return null;
        }

        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setId( doctor.getId() );
        doctorDto.setName( doctor.getName() );
        doctorDto.setEmail( doctor.getEmail() );
        doctorDto.setDob( doctor.getDob() );
        doctorDto.setDepartmentDto(departmentMapper.toDepartmentDto(doctor.getDepartment()));
        return doctorDto;
    }


}
