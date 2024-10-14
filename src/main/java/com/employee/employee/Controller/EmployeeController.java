package com.employee.employee.Controller;


import com.employee.employee.Entity.Employee;
import com.employee.employee.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/addemployee")
    public Employee addemployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity deleteemployee(@PathVariable long id){
        Employee employee1 = employeeService.getbyid(id);
        employeeService.deleteemployee(id);
       return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/allemployees")
    public List<Employee> getallemployees(){
        return employeeService.getallemployees();
    }

    @GetMapping("/getbyid/{id}")
    public Employee getbyid(@PathVariable long id){
        return employeeService.getbyid(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id, @RequestBody Employee newEmployeeData) {
        Employee updatedEmployee = employeeService.updateEmployee(id, newEmployeeData);

        if (updatedEmployee == null) {
            return ResponseEntity.ok("Employee not found");
        }
        return ResponseEntity.ok("Employee updated successfully");
    }


}
