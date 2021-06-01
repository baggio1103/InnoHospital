package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;

import java.util.List;
import java.util.Set;

public interface PatientService {

    PatientDto save(PatientDto patientDto);

    List<PatientDto> findAll();

    PatientDto findById(Integer id);

    PatientDto updateById(Integer id, PatientDto patientDto);

    PatientDto deleteById(Integer id);

    Set<DoctorDto> getPatientDoctors(Integer patientId);

    PatientDto addPatientDoctor(Integer patientId, Integer doctorId);

    PatientDto deletePatientDoctor(Integer patientId, Integer doctorId);

}
