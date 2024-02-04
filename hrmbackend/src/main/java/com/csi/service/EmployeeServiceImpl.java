package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveData(Employee employee){
        return employeeRepository.save(employee);
    }
}
