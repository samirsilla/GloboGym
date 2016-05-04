package com.javaclass.gymapp.repository;

import com.javaclass.gymapp.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}