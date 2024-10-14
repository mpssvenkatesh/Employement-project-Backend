package com.employee.employee.Service;


import com.employee.employee.Entity.Employee;
import com.employee.employee.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public void deleteemployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getbyid(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getallemployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(long id, Employee newEmployeeData) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null;
        }
        existingEmployee.setName(newEmployeeData.getName());
        existingEmployee.setEmail(newEmployeeData.getEmail());
        existingEmployee.setPhone(newEmployeeData.getPhone());
        existingEmployee.setDepartment(newEmployeeData.getDepartment());
        return employeeRepository.save(existingEmployee);
    }


}
