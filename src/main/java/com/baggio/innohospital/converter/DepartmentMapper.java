package com.baggio.innohospital.converter;

import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.dto.DepartmentDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department toDepartment(DepartmentDto departmentDto){
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();
        department.setId( departmentDto.getId() );
        department.setName( departmentDto.getName() );

        return department;
    }

    public DepartmentDto toDepartmentDto(Department department){
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );

        return departmentDto;
    }

}
