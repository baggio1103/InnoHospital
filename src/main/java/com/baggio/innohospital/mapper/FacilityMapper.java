package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Facility;
import com.baggio.innohospital.dto.FacilityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface FacilityMapper {

    FacilityMapper Instance = Mappers.getMapper(FacilityMapper.class);

    Facility toFacility(FacilityDto facilityDto);

    FacilityDto toFacilityDto(Facility facility);

}
