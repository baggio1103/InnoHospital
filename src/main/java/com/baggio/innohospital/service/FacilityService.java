package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.FacilityDto;

import java.util.List;

public interface FacilityService {

    FacilityDto save(FacilityDto facilityDto);

    List<FacilityDto> findAll();

    FacilityDto findById(Integer id);

    FacilityDto update(Integer id, FacilityDto facilityDto);

    FacilityDto deleteById(Integer id);

    FacilityDto addFacilityDoctor(Integer facilityId, Integer doctorId);
}

