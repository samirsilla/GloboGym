package com.javaclass.gymapp.controller;

import com.javaclass.gymapp.domain.Employee;
import com.javaclass.gymapp.service.EmployeeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateEmployee(@RequestBody String jsonEmployee){

        JSONObject object = new JSONObject(jsonEmployee);

        Employee employee = new Employee();
        employee.setEmployeeId(object.getLong("employeeId"));
        employee.setFirstName(object.getString("firstName"));
        employee.setLastName(object.getString("lastName"));
        employee.setEmployeeNumber(object.getString("employeeNumber"));
        try{
            employee.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }
        try {
            employeeService.updateEmployee(employee);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody String jsonEmployee){

        JSONObject object = new JSONObject(jsonEmployee);

        Employee employee = new Employee();
        employee.setFirstName(object.getString("firstName"));
        employee.setLastName(object.getString("lastName"));
        employee.setEmployeeNumber(object.getString("employeeNumber"));
        try{
            employee.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }
        try {
            employeeService.createEmployee(employee);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id){

        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}