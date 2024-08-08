package com.task1.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerEmployee {
    @JsonProperty("manager")
    private Manager manager;
    @JsonProperty("EmployeeList")
    private List<Employee> EmployeeList;

    public ManagerEmployee() {

    }

    public ManagerEmployee(com.task1.manager.model.Manager manager, List<Employee> employeeList) {
        this.manager = manager;
        EmployeeList = employeeList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    @JsonProperty("EmployeeList")
    public List<Employee> getEmployeeList() {
        return EmployeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        EmployeeList = employeeList;
    }

    @Override
    public String toString() {
        
        return "{manager:'" + manager + "', EmployeeList:" + EmployeeList + "}";
    }





    


    
    
}
