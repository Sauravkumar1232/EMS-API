package com.example.emsapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emsapi.entity.Employe;

@Repository
public interface EmployeeRepository extends JpaRepository<Employe,Long>{

}
