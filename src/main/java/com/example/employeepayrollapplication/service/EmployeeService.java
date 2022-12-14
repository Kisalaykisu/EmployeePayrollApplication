package com.example.employeepayrollapplication.service;

import com.example.employeepayrollapplication.dto.EmpDto;
import com.example.employeepayrollapplication.model.EmployeeEntity;
import com.example.employeepayrollapplication.dto.EmpDto;
import com.example.employeepayrollapplication.model.EmployeeEntity;
import com.example.employeepayrollapplication.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    Repo repository;
    public String welcomeMessage(){
        return "This is Employee Payroll App";
    }

    public EmployeeEntity saveData(EmpDto empData) {
        EmployeeEntity newEmpData = new EmployeeEntity(empData);
        repository.save(newEmpData);
        return newEmpData;
    }

    public Optional<EmployeeEntity> findById(Long id) {
        return repository.findById(id);
    }

    public List<EmployeeEntity> findAllData() {
        return repository.findAll();
    }

    public EmployeeEntity editData(EmpDto empData, Long id) {
        EmployeeEntity existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
//            existingGreet.setEmployeeId(empData.getEmployeeId());
            existingGreet.setEmployeeName(empData.getEmployeeName());
            existingGreet.setProfilePic(empData.getProfilePic());
            existingGreet.setGender(empData.getGender());
            existingGreet.setSalary(empData.getSalary());
            existingGreet.setDepartment(empData.getDepartment());
            existingGreet.setStartDate(empData.getStartDate());
            existingGreet.setNotes(empData.getNotes());
            return repository.save(existingGreet);
        }
        else
            return null;
    }

    public void deleteData(Long id) {
        repository.deleteById(id);
    }
}