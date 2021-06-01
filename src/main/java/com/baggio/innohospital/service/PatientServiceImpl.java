package com.baggio.innohospital.service;

import com.baggio.innohospital.converter.DoctorMapper;
import com.baggio.innohospital.converter.PatientMapper;
import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.data.Patient;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;
import com.baggio.innohospital.repository.DoctorRepository;
import com.baggio.innohospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository repository;
    private final DoctorRepository doctorRepository;
    private final PatientMapper mapper;
    private final DoctorMapper doctorMapper;

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = mapper.toPatient(patientDto);
        return mapper.toPatientDto(repository.save(patient));
    }

    @Override
    public List<PatientDto> findAll() {
        return repository.findAll().stream().map(mapper::toPatientDto).collect(Collectors.toList());
    }

    @Override
    public PatientDto findById(Integer id) {
        Patient patient = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        return mapper.toPatientDto(patient);
    }

    @Override
    public PatientDto updateById(Integer id, PatientDto patientDto) {
        Patient newPatient = mapper.toPatient(patientDto);
        Patient dbPatient = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Patient not found!"));
        newPatient.setId(dbPatient.getId());
        return mapper.toPatientDto(repository.save(newPatient));
    }

    @Override
    public PatientDto deleteById(Integer id) {
        Patient patient = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        repository.deleteById(id);
        return mapper.toPatientDto(patient);
    }

    @Override
    public Set<DoctorDto> getPatientDoctors(Integer patientId) {
        Patient patient = repository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        return patient.getDoctors().stream().map(doctorMapper::toDoctorDto).collect(Collectors.toSet());
    }

    @Override
    public PatientDto addPatientDoctor(Integer patientId, Integer doctorId) {
        Patient patient = repository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor not Found!"));
        patient.getDoctors().add(doctor);
        return mapper.toPatientDto(repository.save(patient));
    }

    @Override
    public PatientDto deletePatientDoctor(Integer patientId, Integer doctorId) {
        Patient patient = repository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor not Found!"));
        patient.getDoctors().remove(doctor);
        return mapper.toPatientDto(repository.save(patient));
    }

}
