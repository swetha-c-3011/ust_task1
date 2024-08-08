package com.task1.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Manager {
    @JsonProperty("name")
    private String managerName;
    @JsonProperty("id")
    private int managerId;
    
    public Manager() {
    }

    public Manager(String managerName, int managerId) {
        this.managerName = managerName;
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        
        return "{name:'"+managerName+"',id:'"+managerId+"'}";
    }
    
    
    

}
