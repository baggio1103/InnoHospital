package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);

    List<DepartmentDto> findAll();

    DepartmentDto findById(Integer id);

    DepartmentDto updateById(Integer id, DepartmentDto departmentDto);

    DepartmentDto deleteById(Integer id);

}
