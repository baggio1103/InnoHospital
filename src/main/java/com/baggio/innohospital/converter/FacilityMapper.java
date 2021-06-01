package com.baggio.innohospital.converter;

import com.baggio.innohospital.data.Facility;
import com.baggio.innohospital.dto.FacilityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FacilityMapper {

    private final DoctorMapper doctorMapper;

    public Facility toFacility(FacilityDto facilityDto) {
        if ( facilityDto == null ) {
            return null;
        }

        Facility facility = new Facility();

        facility.setId( facilityDto.getId() );
        facility.setDescription( facilityDto.getDescription() );
        facility.setPrice( facilityDto.getPrice() );
        facility.setDoctor(doctorMapper.toDoctor(facilityDto.getDoctorDto()));

        return facility;
    }

    public FacilityDto toFacilityDto(Facility facility) {
        if ( facility == null ) {
            return null;
        }

        FacilityDto facilityDto = new FacilityDto();

        facilityDto.setId( facility.getId() );
        facilityDto.setDescription( facility.getDescription() );
        facilityDto.setPrice( facility.getPrice() );
        facilityDto.setDoctorDto(doctorMapper.toDoctorDto(facility.getDoctor()));

        return facilityDto;
    }

}
