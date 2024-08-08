package com.task1.manager.controller;
// import com.task1.model.ManagerEmployee;
// import com.task1.model.Employee;
// import com.task1.model.Manager;
// import com.task1.model.updateData;

// import com.task1.service.EmployeeService;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

import com.task1.manager.service.EmployeeService;
import com.task1.manager.model.updateData;

@RestController
@RequestMapping("/updateManager")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateEmployeeDetails(@RequestBody updateData ud) throws IOException {
        return employeeService.updateEmployeeDetails(ud);
    }
}

