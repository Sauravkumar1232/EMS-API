package com.example.emsapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.emsapi.dao.EmployeeRepository;
import com.example.emsapi.dto.EmployeDto;
import com.example.emsapi.dto.ResponseDto;
import com.example.emsapi.entity.Employe;

@Service
public class EmployeeService {
   
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseDto<String> save(EmployeDto employeeDto) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        Employe employe = Employe.builder().name(employeeDto.getName()).age(employeeDto.getAge()).email(employeeDto.getEmail()).phone(employeeDto.getPhone()).userName(employeeDto.getUserName()).build();
        employeeRepository.save(employe);
        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage("Created");
        responseDto.setStatus(HttpStatus.OK);
        return responseDto;
    }

    public ResponseDto<EmployeDto> getById(Long id) {
        ResponseDto<EmployeDto> responseDto = new ResponseDto<EmployeDto>();
        Optional<Employe> employe=employeeRepository.findById(id);
        if(Objects.nonNull(employe)) {
            EmployeDto employeDto=modelMapper.map(employe.get(), EmployeDto.class);
            responseDto.setData(employeDto);
            responseDto.setCode(HttpStatus.OK.value());
            responseDto.setMessage("Success");
            responseDto.setStatus(HttpStatus.OK);
            
        }
        return responseDto;
    }

    public ResponseDto<List<EmployeDto>> getAll() {
        // TODO Auto-generated method stub
        ResponseDto<List<EmployeDto>> responseDto = new ResponseDto<List<EmployeDto>>();
        List<Employe>employes = employeeRepository.findAll();
//        List<EmployeDto>employeDtos=new ArrayList<>();
//        employes.forEach(employe->{
//            EmployeDto employeDto = modelMapper.map(employe, EmployeDto.class);
//            employeDtos.add(employeDto);
//        });
        List<EmployeDto>employeDtos= employes.stream().map(employe->modelMapper.map(employe, EmployeDto.class)).collect(Collectors.toList());
        responseDto.setData(employeDtos);
        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage("Success");
        responseDto.setStatus(HttpStatus.OK);
        return responseDto;
    }

    public ResponseDto<String> update(Long id,EmployeDto dto) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        Optional<Employe> employeOptional=employeeRepository.findById(id);
        
        if(Objects.nonNull(employeOptional)) {
            Employe employe=employeOptional.get();
//            employe = Employe.builder().name(employeeDto.getName()).age(employeeDto.getAge()).email(employeeDto.getEmail()).phone(employeeDto.getPhone()).userName(employeeDto.getUserName()).build();
            employe.setAge(dto.getAge());
            employe.setEmail(dto.getEmail());
            employe.setName(dto.getName());
            employe.setPhone(dto.getPhone());
            employe.setUserName(dto.getUserName());
            employeeRepository.save(employe);
        }
        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage("Updated");
        responseDto.setStatus(HttpStatus.OK);
        return responseDto;
    }

    public ResponseDto<String> deleteById(Long id) {
        ResponseDto<String> responseDto = new ResponseDto<>();
//        Optional<Employe> employeOptional = employeeRepository.findById(id);
        if(Objects.nonNull(id)) {
//            employeOptional.get().setDeleted(true);
         employeeRepository.deleteById(id);  
//        permanent delete row
            
//            employeeRepository.save(employeOptional.get());
            responseDto.setCode(HttpStatus.OK.value());
            responseDto.setMessage("Deleted");
            responseDto.setStatus(HttpStatus.OK);
        }
        return responseDto;
    }

}
