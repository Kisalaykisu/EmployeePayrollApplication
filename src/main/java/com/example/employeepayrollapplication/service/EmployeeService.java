package com.example.employeepayrollapplication.service;

import com.example.employeepayrollapplication.model.EmployeeEntity;
import com.example.employeepayrollapplication.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    Repo repository;
    public String welcomeMessage(){
        return "This is Employee Payroll App";
    }

    public EmployeeEntity saveData(EmployeeEntity empData) {
        repository.save(empData);
        return empData;
    }
}
