package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.dto.PatientDto;
import com.baggio.innohospital.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("")
    public List<PatientDto> getAll(){
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public PatientDto getPatient(@PathVariable("patientId") Integer id){
        return patientService.findById(id);
    }

    @PostMapping("")
    public PatientDto addPatient(@RequestBody PatientDto patientDto){
        return patientService.save(patientDto);
    }

    @DeleteMapping("/{patientId}")
    public PatientDto deletePatient(@PathVariable("patientId")Integer id){
        return patientService.deleteById(id);
    }


    @PutMapping("/{patientId}")
    public PatientDto updatePatient(@PathVariable("patientId")Integer id, @RequestBody PatientDto patientDto){
        return patientService.updateById(id, patientDto);
    }

    @GetMapping("/{patientId}/doctors/")
    public Set<DoctorDto> getClientDoctors(@PathVariable("patientId")Integer patientId){
        return patientService.getPatientDoctors(patientId);
    }

    @PutMapping("/{patientId}/doctors/{doctorId}")
    public PatientDto addPatientDoctor(@PathVariable("patientId")Integer patientId,
                                       @PathVariable("doctorId")Integer doctorId){
        return patientService.addPatientDoctor(patientId, doctorId);
    }

    @DeleteMapping("/{patientId}/doctors/{doctorId}")
    public PatientDto deletePatientDoctor(@PathVariable("patientId")Integer patientId,
                                       @PathVariable("doctorId")Integer doctorId){
        return patientService.deletePatientDoctor(patientId, doctorId);
    }


}
