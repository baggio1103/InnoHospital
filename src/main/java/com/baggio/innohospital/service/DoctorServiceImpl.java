package com.baggio.innohospital.service;

import com.baggio.innohospital.converter.PatientMapper;
import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.data.Patient;
import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;
import com.baggio.innohospital.converter.DoctorMapper;
import com.baggio.innohospital.repository.DepartmentRepository;
import com.baggio.innohospital.repository.DoctorRepository;
import com.baggio.innohospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DepartmentRepository departmentRepository;
    private final DoctorMapper mapper;
    private final PatientMapper patientMapper;

    @Override
    public DoctorDto save(DoctorDto doctorDto) {
        Doctor doctor = mapper.toDoctor(doctorDto);
        return mapper.toDoctorDto(doctorRepository.save(doctor));
    }

    @Override
    public List<DoctorDto> findAll() {
        return doctorRepository.findAll().stream().map(mapper::toDoctorDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDto findById(Integer id) {
        return mapper.toDoctorDto(doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!")));
    }

    @Override
    public DepartmentDto findDepartmentById(Integer id) {
        return findById(id).getDepartmentDto();
    }

    @Override
    public List<PatientDto> getDoctorPatients(Integer id) {
        return doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!")).
                getPatients().stream().map(patientMapper::toPatientDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDto deleteById(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!"));
        doctorRepository.deleteById(id);
        return mapper.toDoctorDto(doctor);
    }

    @Override
    public DoctorDto updateById(Integer id, DoctorDto doctorDto) {
        Doctor newDoctor = mapper.toDoctor(doctorDto);
        Doctor dbDoctor = doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!"));
        newDoctor.setId(dbDoctor.getId());
        return mapper.toDoctorDto(doctorRepository.save(newDoctor));
    }

    @Override
    public List<DoctorDto> findAllDoctorsByDepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()
                -> new EntityNotFoundException("Entity not found"));
        return doctorRepository.findAllByDepartment(department).
                stream().map(mapper::toDoctorDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDto setDoctorsDepartment(Integer doctorId, Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()
                -> new EntityNotFoundException("Entity not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!"));
        doctor.setDepartment(department);
        return mapper.toDoctorDto(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDto addPatientDoctor(Integer patientId, Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor not Found!"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        doctor.getPatients().add(patient);
        return mapper.toDoctorDto(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDto deletePatientDoctor(Integer patientId, Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor not Found!"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        doctor.getPatients().remove(patient);
        return mapper.toDoctorDto(doctorRepository.save(doctor));
    }


}
