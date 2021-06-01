package com.baggio.innohospital.service;

import com.baggio.innohospital.data.Doctor;
import com.baggio.innohospital.data.Facility;
import com.baggio.innohospital.dto.FacilityDto;
import com.baggio.innohospital.converter.FacilityMapper;
import com.baggio.innohospital.repository.DoctorRepository;
import com.baggio.innohospital.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService{

    private final FacilityRepository repository;
    private final DoctorRepository doctorRepository;
    private final FacilityMapper mapper;

    @Override
    public FacilityDto save(FacilityDto facilityDto) {
        Facility facility = mapper.toFacility(facilityDto);
        return mapper.toFacilityDto(repository.save(facility));
    }

    @Override
    public List<FacilityDto> findAll() {
        return repository.findAll().stream().map(mapper::toFacilityDto).collect(Collectors.toList());
    }

    @Override
    public FacilityDto findById(Integer id) {
        Facility facility = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Facility not found"));
        return mapper.toFacilityDto(facility);
    }

    @Override
    public FacilityDto update(Integer id, FacilityDto facilityDto) {
        Facility facility = mapper.toFacility(facilityDto);
        Facility dbFacility = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Facility not found"));
        facility.setId(dbFacility.getId());
        repository.save(facility);
        return mapper.toFacilityDto(facility);
    }

    @Override
    public FacilityDto deleteById(Integer id) {
        Facility facility = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Facility not found"));
        repository.deleteById(id);
        return mapper.toFacilityDto(facility);
    }

    @Override
    public FacilityDto addFacilityDoctor(Integer facilityId, Integer doctorId) {
        Facility facility = repository.findById(facilityId).
                orElseThrow(() -> new EntityNotFoundException("Facility not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Entity not Found!"));
        facility.setDoctor(doctor);
        return mapper.toFacilityDto(repository.save(facility));
    }


}
