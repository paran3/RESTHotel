package com.restcompany.room;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class RoomInitializer {

    private Rooms rooms;

    public RoomInitializer(Rooms rooms) {

        this.rooms = rooms;

        System.out.println("RoomInitializer");

        Room r1 = new Room(101, 2, 10000, "Double", Status.BEFORE_CLEANING);
        Room r2 = new Room(102, 2, 10000, "Double", Status.BEFORE_CLEANING);
        Room r3 = new Room(103, 2, 10000, "Double", Status.BEFORE_CLEANING);
        Room r4 = new Room(201, 3, 20000, "Deluxe", Status.BEFORE_CLEANING);
        Room r5 = new Room(202, 3, 20000, "Deluxe", Status.BEFORE_CLEANING);
        Room r6 = new Room(203, 3, 20000, "Deluxe", Status.BEFORE_CLEANING);
        Room r7 = new Room(301, 5, 40000, "Suite", Status.BEFORE_CLEANING);
        Room r8 = new Room(302, 5, 40000, "Suite", Status.BEFORE_CLEANING);
        Room r9 = new Room(303, 5, 40000, "Suite", Status.BEFORE_CLEANING);

        Stream.of(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                .forEach(this.rooms::save);

    }
}
