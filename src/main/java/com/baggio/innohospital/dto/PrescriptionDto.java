package com.baggio.innohospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto extends BaseEntityDto{

    private String prescription;

    private DoctorDto doctorDto;

    private PatientDto patientDto;

}
