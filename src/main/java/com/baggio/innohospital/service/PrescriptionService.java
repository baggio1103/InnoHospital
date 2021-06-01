package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDto save(PrescriptionDto prescriptionDto);

    List<PrescriptionDto> findAll();

    PrescriptionDto findById(Integer id);

    PrescriptionDto updateById(Integer id, PrescriptionDto prescriptionDto);

    PrescriptionDto deleteById(Integer id);

    PrescriptionDto appointPrescriptionPatient(Integer prescriptionId, Integer doctorId, Integer patientId);
}
