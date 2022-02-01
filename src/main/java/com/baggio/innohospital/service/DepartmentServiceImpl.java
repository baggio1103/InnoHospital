package com.baggio.innohospital.service;

import com.baggio.innohospital.converter.DepartmentMapper;
import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.dto.DepartmentDto;
import com.baggio.innohospital.exception.domain.DepartmentNotFoundException;
import com.baggio.innohospital.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        List<Department> departments = repository.findAll();
        long start = System.currentTimeMillis();
        if (!CollectionUtils.isEmpty(departments)) {
            System.out.println("Not empty");
        }
        long end = System.currentTimeMillis();
        log.info("Exec time:{}", (end - start));
        return departments.stream().map(mapper::toDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return mapper.toDepartmentDto(repository.findById(id).orElseThrow(()
                -> new DepartmentNotFoundException("Department not found by id: " + id)));
    }

    @Override
    public DepartmentDto updateById(Integer id, DepartmentDto departmentDto) {
        Department newDepartment = mapper.toDepartment(departmentDto);
        Department dbDepartment = repository.findById(id).orElseThrow(()
                -> new DepartmentNotFoundException("Department not found by id: " + id));
        newDepartment.setId(dbDepartment.getId());
        return mapper.toDepartmentDto(repository.save(newDepartment));
    }

    @Override
    public DepartmentDto deleteById(Integer id) {
        Department department = repository.findById(id).orElseThrow(()
                -> new DepartmentNotFoundException("Department not found by id: " + id));
        repository.deleteById(id);
        return mapper.toDepartmentDto(department);
    }

}
