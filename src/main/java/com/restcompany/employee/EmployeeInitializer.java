package com.restcompany.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EmployeeInitializer {

    private Employees employees;

    public EmployeeInitializer(Employees employees){

        this.employees = employees;

        System.out.println("EmployeeInitializer");

        Employee e1 = new Employee("TaeMin","Kim");
        Employee e2 = new Employee("GilDong","Hong");

        Stream.of(e1,e2)
                .forEach(this.employees::save);

    }

}