package com.example.emsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emsapi.dto.EmployeDto;
import com.example.emsapi.dto.ResponseDto;
import com.example.emsapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseDto<String> save(@RequestBody EmployeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @PutMapping("update")
    public ResponseDto<String> update(@RequestBody EmployeDto employeeDto) {
        return employeeService.update(employeeDto);
    }

    @DeleteMapping("delete")
    public ResponseDto<String> deleteById(Long id) {
        return employeeService.deleteById(id);
    }

    @GetMapping("getById/{id}")
    public ResponseDto<EmployeDto> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<EmployeDto>> getAll() {
        return employeeService.getAll();
    }

}
