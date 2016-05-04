package com.javaclass.gymapp.service;

import com.javaclass.gymapp.domain.Employee;
import com.javaclass.gymapp.repository.EmployeeRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> findAll(){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepo.findAll()) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee findOne(Employee user){
        return employeeRepo.findOne(user.getEmployeeId());
    }

    public void updateEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void createEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.delete(id);
    }

    public Employee jsonEmployeeToEmployee(JSONObject object){
        Employee temp = new Employee();
        try{
            temp.setEmployeeId(object.getLong("id"));
        }catch (Exception e){

        }
        temp.setFirstName(object.getString("firstName"));
        temp.setLastName(object.getString("lastName"));
        try{
            temp.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }
        return temp;
    }
}