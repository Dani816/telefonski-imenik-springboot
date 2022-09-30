package com.danijel.SpringBootThymeleafCRUD.repository;

import com.danijel.SpringBootThymeleafCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
