package com.bharath.springdatarest.department.repos;

import org.springframework.data.repository.CrudRepository;

import com.bharath.springdatarest.department.entities.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
