package com.restcompany.service;

import com.restcompany.employee.Employee;
import com.restcompany.employee.Employees;
import com.restcompany.room.Room;
import com.restcompany.room.Rooms;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CleaningEngine {

    private final Employees employees;

    private final Rooms rooms;

    public CleaningEngine(Employees employees, Rooms rooms) {
        this.employees = employees;
        this.rooms = rooms;
    }

    @Async
    public void process(Employee employee, Room room) {
        employees.markBusy(employee);
        rooms.markCleaning(room);

        employee.cleaning(room.getNumber());

        rooms.markReady(room);
        employees.markFree(employee);
    }
}
