package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.dto.DoctorDto;
import com.baggio.innohospital.service.DepartmentService;
import com.baggio.innohospital.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DoctorService doctorService;

    @GetMapping("")
    public List<DepartmentDto> getAll(){
        return departmentService.findAll();
    }

    @PostMapping("")
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.save(departmentDto);
    }

    @GetMapping("/{id}")
    public DepartmentDto findDepartmentById(@PathVariable("id") Integer id){
        return departmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public DepartmentDto deleteDepartment(@PathVariable("id")Integer id){
        return departmentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public DepartmentDto updateDepartment(@PathVariable("id")Integer id, @RequestBody DepartmentDto departmentDto){
        return departmentService.updateById(id, departmentDto);
    }

    @GetMapping("/{id}/doctors")
    public List<DoctorDto> getDepartmentDoctors(@PathVariable("id") Integer id){
        return doctorService.findAllDoctorsByDepartment(id);
    }

}
