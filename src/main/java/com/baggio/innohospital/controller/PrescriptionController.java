package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.PrescriptionDto;
import com.baggio.innohospital.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@AllArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping("")
    public List<PrescriptionDto> getAll(){
        return prescriptionService.findAll();
    }

    @GetMapping("/{prescriptionId}")
    public PrescriptionDto getPrescription(@PathVariable("prescriptionId")Integer prescriptionId){
        return prescriptionService.findById(prescriptionId);
    }

    @PostMapping("")
    public PrescriptionDto addPrescription(@RequestBody PrescriptionDto prescriptionDto){
        return prescriptionService.save(prescriptionDto);
    }

    @PutMapping("/{prescriptionId}")
    public PrescriptionDto updatePrescription(@PathVariable("prescriptionId")Integer prescriptionId,
                                              @RequestBody PrescriptionDto prescriptionDto){
        return prescriptionService.updateById(prescriptionId, prescriptionDto);
    }

    @DeleteMapping("/{prescriptionId}")
    public PrescriptionDto deletePresciption(@PathVariable("prescriptionId") Integer prescriptionId){
        return prescriptionService.deleteById(prescriptionId);
    }

    @PutMapping("/{prescriptionId}/doctor/{doctorId}/patient/{patientId}")
    public PrescriptionDto appointPrescriptionPatient(@PathVariable("prescriptionId")Integer prescriptionId,
                                                      @PathVariable("doctorId") Integer doctorId,
                                                      @PathVariable("patientId") Integer patientId){
        return prescriptionService.appointPrescriptionPatient(prescriptionId, doctorId, patientId);
    }

}
