package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/employees")
@Slf4j
@Tag(name = "EmployeeController", description = "this class is used for Employee Controller API")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;


    @Operation(summary = "Save Data", description = "save employee data",
            responses = {
                    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = Employee.class))),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = LinkedHashMap.class)))
            })
    @PostMapping("/save")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){

        log.info("$$$$$$$$$$$$$$Trying to save data for Employee: "+ employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }
}
