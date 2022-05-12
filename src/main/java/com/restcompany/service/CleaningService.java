package com.restcompany.service;

import com.restcompany.employee.Employees;
import com.restcompany.room.Rooms;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class CleaningService {

    private final Employees employees;

    private final Rooms rooms;

    public CleaningService(Employees employees, Rooms rooms) {
        this.employees = employees;
        this.rooms = rooms;
    }

    /*
    batch process (every minute)
     */
    private void check() {
        /*
        1. rooms.isRequiredCleaning()
        2. employees.isAvailable()
        3. call asynchronous run method
        4. return
         */
    }

    @Async
    private void run() {
        /*
        1. employees.available()
        2. for loop with available employees
        3. in for loop
        3-1. changing status to (employee - busy, room - cleaning) and save
        3-2. call employee's asynchronous cleaning method
        3-3. changing status to (employee - free, room - ready) and save
         */
    }
}
