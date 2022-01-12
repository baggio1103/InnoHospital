package com.baggio.innohospital.service;

import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.converter.DepartmentMapper;
import com.baggio.innohospital.exception.DepartmentNotFoundException;
import com.baggio.innohospital.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private  final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = mapper.toDepartment(departmentDto);
        return mapper.toDepartmentDto(repository.save(department));
    }


    @Override
    public List<DepartmentDto> findAll() {
        return repository.findAll().stream().map(mapper::toDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return mapper.toDepartmentDto(repository.findById(id).orElseThrow(()
                -> new DepartmentNotFoundException("Department not found by id:" + id)));
    }

    @Override
    public DepartmentDto updateById(Integer id, DepartmentDto departmentDto) {
        Department newDepartment = mapper.toDepartment(departmentDto);
        Department dbDepartment = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Entity not found"));
        newDepartment.setId(dbDepartment.getId());
        return mapper.toDepartmentDto(repository.save(newDepartment));
    }

    @Override
    public DepartmentDto deleteById(Integer id) {
        Department department = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Entity not found"));
        repository.deleteById(id);
        return mapper.toDepartmentDto(department);
    }

}
