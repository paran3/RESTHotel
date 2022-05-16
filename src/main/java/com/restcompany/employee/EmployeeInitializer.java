package com.restcompany.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Slf4j
@Service
public class EmployeeInitializer {

    private Employees employees;

    public EmployeeInitializer(Employees employees) {

        this.employees = employees;

        LOG.info("EmployeeInitializer");

        Employee e1 = new Employee("TaeMin", "Kim", Status.FREE);
        Employee e2 = new Employee("GilDong", "Hong", Status.FREE);
        Employee e3 = new Employee("Jack", "Holy", Status.FREE);
        Employee e4 = new Employee("Pretty", "Kong", Status.FREE);
        Employee e5 = new Employee("Elsa", "Froze", Status.FREE);

        Stream.of(e1, e2,e3,e4,e5)
                .forEach(this.employees::save);

    }

}