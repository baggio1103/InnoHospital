package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.FacilityDto;
import com.baggio.innohospital.service.FacilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
@AllArgsConstructor
public class FacilityController {

    private final FacilityService service;

    @GetMapping("")
    public List<FacilityDto> getAllFacilities(){
        return service.findAll();
    }

    @GetMapping("/{facilityId}")
    public FacilityDto getFacility(@PathVariable("facilityId")Integer id){
        return service.findById(id);
    }

    @PostMapping
    public FacilityDto addFacility(@RequestBody FacilityDto facilityDto){
        return service.save(facilityDto);
    }

    @DeleteMapping("/{facilityId}")
    public FacilityDto removeFacility(@PathVariable("facilityId")Integer id){
        return service.deleteById(id);
    }

    @PutMapping("/{facilityId}")
    public FacilityDto updateFacility(@PathVariable("facilityId")Integer id,
                                      @RequestBody FacilityDto facilityDto){
        return service.update(id, facilityDto);
    }

    @PutMapping("/{facilityId}/doctor/{doctorId}")
    public FacilityDto addFacilityDoctor(@PathVariable("facilityId") Integer facilityId,
                                         @PathVariable("doctorId") Integer doctorId){
        return service.addFacilityDoctor(facilityId, doctorId);
    }

}
