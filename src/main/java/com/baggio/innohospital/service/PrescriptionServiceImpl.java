package com.baggio.innohospital.service;

import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.data.Patient;
import com.baggio.innohospital.data.Prescription;
import com.baggio.innohospital.dto.PrescriptionDto;
import com.baggio.innohospital.converter.PrescriptionMapper;
import com.baggio.innohospital.repository.DoctorRepository;
import com.baggio.innohospital.repository.PatientRepository;
import com.baggio.innohospital.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService{

    private final PrescriptionRepository repository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PrescriptionMapper mapper;


    @Override
    public PrescriptionDto save(PrescriptionDto prescriptionDto) {
        Prescription prescription = mapper.toPrescription(prescriptionDto);
        return mapper.toPrescriptionDto(repository.save(prescription));
    }

    @Override
    public List<PrescriptionDto> findAll() {
        return repository.findAll().stream().map(mapper::toPrescriptionDto).collect(Collectors.toList());
    }

    @Override
    public PrescriptionDto findById(Integer id) {
        Prescription prescription = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found"));
        return mapper.toPrescriptionDto(prescription);
    }

    @Override
    public PrescriptionDto updateById(Integer id, PrescriptionDto prescriptionDto) {
        Prescription prescription = mapper.toPrescription(prescriptionDto);
        Prescription dbPrescription = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found"));
        prescription.setId(dbPrescription.getId());
        repository.save(prescription);
        return mapper.toPrescriptionDto(prescription);
    }

    @Override
    public PrescriptionDto deleteById(Integer id) {
        Prescription prescription = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found"));
        repository.deleteById(id);
        return mapper.toPrescriptionDto(prescription);
    }

    @Override
    public PrescriptionDto appointPrescriptionPatient(Integer prescriptionId, Integer doctorId, Integer patientId) {
        Prescription prescription = repository.findById(prescriptionId).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found!"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor not Found!"));
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        return mapper.toPrescriptionDto(prescription);
    }

}
