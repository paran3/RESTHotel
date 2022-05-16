package com.restcompany.service;

import com.restcompany.employee.Employee;
import com.restcompany.employee.Employees;
import com.restcompany.room.Room;
import com.restcompany.room.Rooms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CleaningService {

    private final Employees employees;

    private final Rooms rooms;

    private final CleaningEngine engine;

    public CleaningService(Employees employees, Rooms rooms, CleaningEngine engine) {
        this.employees = employees;
        this.rooms = rooms;
        this.engine = engine;
    }

    /*
    batch process (every minute)
     */
    @Scheduled(cron = "0 */1 * * * *")
    private void check() {
        LOG.info(
                "schedule tasks using cron jobs - " + LocalDateTime.now());
        /*
        1. rooms.isRequiredCleaning()
        2. employees.isAvailable()
        3. call asynchronous run method
        4. return
         */

        if (rooms.isRequiredCleaning() && employees.isAvailable()) {
            run();
        }

        return;
    }

    private void run() {
        /*
        1. employees.available()
        2. for loop with available employees
        3. in for loop
        3-1. changing status to (employee - busy, room - cleaning) and save
        3-2. call engine asynchronous method
        3-3. changing status to (employee - free, room - ready) and save
         */
        employees.getAvailable().forEach(employee -> {
            Room room = rooms.getRequiredCleaning();

            if (room == null) {
                return;
            }

            engine.process(employee, room);
        });
    }

}
