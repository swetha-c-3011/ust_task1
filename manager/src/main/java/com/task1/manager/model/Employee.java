package com.task1.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("name")
    private String employeeName;
    @JsonProperty("id")
    private int employeeId;
    @JsonProperty("managerName")
    
    private String  assignedManagerName;
    @JsonProperty("managerId")
    private int  assignedManagerId;

    private String stream;
    private String designation;
    @JsonProperty("yearsOfExperience")
    private int  employeeYearsOfExperience;

    public Employee() {
    }
    

    public Employee(Employee e) {
        this.employeeName = e.employeeName;
        this.employeeId = e.employeeId;
        this.assignedManagerName = e.assignedManagerName;
        this.assignedManagerId = e.assignedManagerId;
        this.stream = e.stream;
        this.designation = e.designation;
        this.employeeYearsOfExperience = e.employeeYearsOfExperience;
    }


    public Employee(String employeeName, int employeeId, String assignedManagerName, int assignedManagerId,
            String stream, String designation, int employeeYearsOfExperience) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.assignedManagerName = assignedManagerName;
        this.assignedManagerId = assignedManagerId;
        this.stream = stream;
        this.designation = designation;
        this.employeeYearsOfExperience = employeeYearsOfExperience;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getAssignedManagerName() {
        return assignedManagerName;
    }
    public void setAssignedManagerName(String assignedManagerName) {
        this.assignedManagerName = assignedManagerName;
    }
    public int getAssignedManagerId() {
        return assignedManagerId;
    }
    public void setAssignedManagerId(int assignedManagerId) {
        this.assignedManagerId = assignedManagerId;
    }
    public String getStream() {
        return stream;
    }
    public void setStream(String stream) {
        this.stream = stream;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public int getEmployeeYearsOfExperience() {
        return employeeYearsOfExperience;
    }
    public void setEmployeeYearsOfExperience(int employeeYearsOfExperience) {
        this.employeeYearsOfExperience = employeeYearsOfExperience;
    }


    @Override
    public String toString() {
       
        return "name:'"+employeeName+"'id:'"+employeeId+"'managerName:'"+assignedManagerName+"'managerId:'"+assignedManagerId+"'stream:'"+stream+"'designation':"+designation+"'experience:'"+employeeYearsOfExperience;
    }


    
    

    

}
