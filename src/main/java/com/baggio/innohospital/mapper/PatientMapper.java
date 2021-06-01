package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Patient;
import com.baggio.innohospital.dto.PatientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface PatientMapper {

    PatientMapper Instance = Mappers.getMapper(PatientMapper.class);

    Patient toPatient(PatientDto patientDto);

    PatientDto toPatientDto(Patient patient);


}
