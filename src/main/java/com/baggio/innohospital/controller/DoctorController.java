package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;
import com.baggio.innohospital.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping("")
    public List<DoctorDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DoctorDto findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping("")
    public DoctorDto saveDoctor(@RequestBody DoctorDto doctorDto){
        return service.save(doctorDto);
    }

    @DeleteMapping("/{id}")
    public DoctorDto deleteDoctor(@PathVariable("id")Integer id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public DoctorDto updateDoctor(@PathVariable("id")Integer id, @RequestBody DoctorDto doctorDto){
        return service.updateById(id, doctorDto);
    }

    @GetMapping("/{id}/department")
    public DepartmentDto getDoctorDepartment(@PathVariable("id")Integer id){
        return service.findDepartmentById(id);
    }

    @PutMapping("/{id}/department/{departmentId}")
    public DoctorDto setDoctorsDepartment(@PathVariable("id") Integer id, @PathVariable("departmentId") Integer departmentId){
        return service.setDoctorsDepartment(id, departmentId);
    }


    @GetMapping("/{id}/patients")
    public List<PatientDto> getPatients(@PathVariable("id") Integer id){
        return service.getDoctorPatients(id);
    }

    @PutMapping("/{doctorId}/patient/{patientId}")
    public DoctorDto addPatientDoctor(@PathVariable("patientId") Integer patientId,
                                   @PathVariable("doctorId") Integer doctorId){
        return service.addPatientDoctor(patientId, doctorId);
    }

    @DeleteMapping("/{doctorId}/patient/{patientId}")
    public DoctorDto deletePatientDoctor(@PathVariable("patientId") Integer patientId,
                                      @PathVariable("doctorId") Integer doctorId){
        return service.deletePatientDoctor(patientId, doctorId);
    }


}
