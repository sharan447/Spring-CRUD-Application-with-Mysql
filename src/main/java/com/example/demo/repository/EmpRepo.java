package com.example.demo.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

}
