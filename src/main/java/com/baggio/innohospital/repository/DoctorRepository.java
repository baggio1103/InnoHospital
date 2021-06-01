package com.baggio.innohospital.repository;

import com.baggio.innohospital.data.Department;
import com.baggio.innohospital.data.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findAllByDepartment(Department department);

}
