package com.example.employeepayrollapplication.dto;

import com.example.employeepayrollapplication.model.EmployeeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;

@Data
@NoArgsConstructor

public class ResponseDto {
    private String message;
    private Object object ;
    public ResponseDto(String string, Model emp) {
        this.message=string;
        this.object = emp;
    }
}
