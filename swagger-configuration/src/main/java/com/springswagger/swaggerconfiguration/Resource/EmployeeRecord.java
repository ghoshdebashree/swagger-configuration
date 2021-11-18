package com.springswagger.swaggerconfiguration.Resource;

import com.springswagger.swaggerconfiguration.Model.Employee;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class EmployeeRecord {
    ConcurrentHashMap<Integer, Employee> employee = new ConcurrentHashMap<>();
    @GetMapping("/{id}")
    @ApiOperation(value= "Find Contact by ID")
    public Employee getEmployeeDetails(@PathVariable int empId){
        return employee.get(empId);
    }
    @GetMapping("/")
    public List<Employee> getAllEmployeeDetails(){
        return new ArrayList<Employee>(employee.values()) ;
    }
    @PostMapping("/")
    public Employee addEmployeeDetails(@RequestBody Employee emp){
        employee.put(emp.getEmpId(), emp);
        return emp;
    }

}
