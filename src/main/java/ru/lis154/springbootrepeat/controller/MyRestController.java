package ru.lis154.springbootrepeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lis154.springbootrepeat.entity.Employee;
import ru.lis154.springbootrepeat.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping ("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployees();
        return allEmployee;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) {
//            throw new NoSuchEmployeeException("There i no employee with id = " + id + "in database");
//
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
//        if(employeeService.getEmployee(id) == null){
//            throw new NoSuchEmployeeException("There is no employee with id = " + id);
//        }
//        else {
            employeeService.deleteEmployee(id);
            return "You delete employee with number = " + id;
        //}



    }







}
