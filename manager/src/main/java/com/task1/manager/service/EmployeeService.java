package com.task1.manager.service;

import com.task1.manager.model.Employee;
import com.task1.manager.model.ManagerEmployee;
import com.task1.manager.model.Manager;
import com.task1.manager.model.updateData;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class EmployeeService {

    public ResponseEntity<Map<String, String>> updateEmployeeDetails(updateData ud) throws StreamReadException, DatabindException, IOException {
        ObjectMapper objmapper = new ObjectMapper();
        objmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(" file printing:"+ud.geteId());
        String name = "", managerName = "", oldmanager = "";
        try {
            File jsonfile = new File("manager/src/main/resources/input_json.json");

            if (!jsonfile.exists()) {
                System.out.println("File does not exist");
                // Handle the file not existing case
            }
           // System.out.println(jsonfile);
            List<ManagerEmployee> empList = objmapper.readValue(jsonfile, new TypeReference<List<ManagerEmployee>>() {});

            Employee tempE = null;
            int index = -1;

            int empcheck = 0, mngrchk = 0;
            for (ManagerEmployee em : empList) {
                List<Employee> elist = em.getEmployeeList();
                for (Employee e : elist) {
                    if (e.getEmployeeId() == ud.geteId()) {
                        System.out.println("from json file "+e.getEmployeeId()+"from api"+ud.geteId());
                        empcheck = 1;
                        index = elist.indexOf(e);
                        tempE = new Employee(e);
                        tempE.setAssignedManagerId(ud.getmId());
                        tempE.setAssignedManagerName(ud.getmName());
                        name = tempE.getEmployeeName();
                        System.out.println(name+" name");
                        oldmanager = e.getAssignedManagerName();
                        System.out.println(oldmanager+" oldmanager");
                        managerName = tempE.getAssignedManagerName();
                        System.out.println(managerName+" managerName");
                    }
                }
                if (empcheck == 1) {
                    elist.remove(index);
                }
            }
            if (empcheck == 0) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "employee does not exist");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            } else {
                for (ManagerEmployee em : empList) {
                    if (em.getManager().getManagerId() == ud.getmId()) {
                        mngrchk = 1;
                        em.getEmployeeList().add(tempE);
                        Collections.sort(em.getEmployeeList(), new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.getEmployeeName().toLowerCase().compareTo(e2.getEmployeeName().toLowerCase());
                            }
                        });
                    }
                }
                if (mngrchk == 0) {
                    Manager m = new Manager(ud.getmName(), ud.getmId());
                    List<Employee> newlist = new ArrayList<>();
                    newlist.add(tempE);
                    ManagerEmployee newem = new ManagerEmployee(m, newlist);
                    empList.add(newem);
                    Collections.sort(empList, new Comparator<ManagerEmployee>() {
                        public int compare(ManagerEmployee el1, ManagerEmployee el2) {
                            return el1.getManager().getManagerName().toLowerCase().compareTo(el2.getManager().getManagerName().toLowerCase());
                        }
                    });
                }
            }
            objmapper.writeValue(jsonfile, empList);
        } catch (Exception e) {
            System.out.println(e);
        }
        Map<String, String> result = new HashMap<>();
        result.put("message", name + "'s manager has been successfully changed from " + oldmanager + " to " + managerName + ".");
        System.out.println(name+" "+oldmanager+" to "+managerName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

