package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;

import java.util.List;

public interface DoctorService {

    DoctorDto save(DoctorDto doctorDto);

    List<DoctorDto> findAll();

    DoctorDto findById(Integer id);

    DepartmentDto findDepartmentById(Integer id);

    List<PatientDto> getDoctorPatients(Integer id);

    DoctorDto deleteById(Integer id);

    DoctorDto updateById(Integer id, DoctorDto doctorDto);

    List<DoctorDto> findAllDoctorsByDepartment(Integer departmentId);

    DoctorDto setDoctorsDepartment(Integer doctorId, Integer departentId);

    DoctorDto addPatientDoctor(Integer patientId, Integer doctorId);

    DoctorDto deletePatientDoctor(Integer patientId, Integer doctorId);

}
