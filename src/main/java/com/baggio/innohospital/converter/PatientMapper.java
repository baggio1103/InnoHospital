package com.baggio.innohospital.converter;

import com.baggio.innohospital.data.Patient;
import com.baggio.innohospital.dto.PatientDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatientMapper {

    public Patient toPatient(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDto.getId() );
        patient.setName( patientDto.getName() );
        patient.setEmail( patientDto.getEmail() );
        patient.setDob( patientDto.getDob() );
        patient.setDateOfArrival( patientDto.getDateOfArrival() );

        return patient;
    }

    public PatientDto toPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setId( patient.getId() );
        patientDto.setName( patient.getName() );
        patientDto.setEmail( patient.getEmail() );
        patientDto.setDob( patient.getDob() );
        patientDto.setDateOfArrival( patient.getDateOfArrival() );

        return patientDto;
    }

}
