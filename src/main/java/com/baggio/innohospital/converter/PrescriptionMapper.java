package com.baggio.innohospital.converter;

import com.baggio.innohospital.data.Prescription;
import com.baggio.innohospital.dto.PrescriptionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrescriptionMapper {

    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    public Prescription toPrescription(PrescriptionDto prescriptionDto) {
        if ( prescriptionDto == null ) {
            return null;
        }

        Prescription prescription = new Prescription();
        prescription.setId(prescription.getId());
        prescription.setPrescription( prescriptionDto.getPrescription() );
        prescription.setPatient(patientMapper.toPatient(prescriptionDto.getPatientDto()));
        prescription.setDoctor(doctorMapper.toDoctor(prescriptionDto.getDoctorDto()));

        return prescription;
    }

    public PrescriptionDto toPrescriptionDto(Prescription prescription) {
        if ( prescription == null ) {
            return null;
        }

        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setId(prescription.getId());
        prescriptionDto.setPrescription( prescription.getPrescription() );
        prescriptionDto.setPatientDto(patientMapper.toPatientDto(prescription.getPatient()));
        prescriptionDto.setDoctorDto(doctorMapper.toDoctorDto(prescription.getDoctor()));
        return prescriptionDto;
    }

}
