package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Prescription;
import com.baggio.innohospital.dto.PrescriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface PrescriptionMapper {

    PrescriptionMapper Instance = Mappers.getMapper(PrescriptionMapper.class);

    Prescription toPrescription(PrescriptionDto prescriptionDto);

    PrescriptionDto toPrescriptionDto(Prescription prescription);


}
