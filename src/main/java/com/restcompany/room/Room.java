package com.restcompany.room;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Room {

    @Id
    private Integer number;

    private Integer people;
    private Integer price;
    private String type;
    private Status status;
//    private Option option;

    public Room() {

    }

    public Room(Integer number, Integer people, Integer price, String type, Status status) {
        this.number = number;
        this.people = people;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public boolean isReady() {
        return this.status == Status.READY;
    }

    public Room markReady() {

        if (this.status != Status.AFTER_CLEANING) {
            throw new IllegalStateException(
                    String.format("Room must be in state (after cleaning) to set ready! Current status: %s", this.status));
        }

        this.status = Status.READY;

        return this;
    }

    public Room markInUse(){

        if (this.status != Status.READY) {
            throw new IllegalStateException(
                    String.format("Room must be in state ready to set (in use) status! Current status: %s", this.status));
        }

        this.status = Status.IN_USE;

        return this;
    }

    public Room markBeforeCleaning() {

        if (this.status != Status.IN_USE) {
            throw new IllegalStateException(
                    String.format("Room must be in state (in use) to set (before cleaning) status! Current status: %s", this.status));
        }

        this.status = Status.BEFORE_CLEANING;

        return this;
    }

    public Room markCleaning() {

        if (this.status != Status.BEFORE_CLEANING) {
            throw new IllegalStateException(
                    String.format("Room must be in state (before cleaning) to set cleaning status! Current status: %s", this.status));
        }

        this.status = Status.CLEANING;

        return this;

    }

    public Room markAfterCleaning() {

        if (this.status != Status.CLEANING) {
            throw new IllegalStateException(
                    String.format("Room must be in state cleaning to set (after cleaning) status! Current status: %s", this.status));
        }

        this.status = Status.AFTER_CLEANING;

        return this;

    }
}
