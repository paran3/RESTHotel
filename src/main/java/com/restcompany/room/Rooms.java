package com.restcompany.room;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Rooms", path = "rooms")
public interface Rooms extends PagingAndSortingRepository<Room, Integer> {

    List<Room> findByStatus(@Param("status") Status status);

    Integer countByStatus(@Param("status") Status status);

    Room findTop1ByStatus(@Param("status") Status status);

    default boolean isRequiredCleaning() {
        if (countByStatus(Status.BEFORE_CLEANING) > 0) {
            return true;
        }
        return false;
    }

    default Room getRequiredCleaning() {
        return findTop1ByStatus(Status.BEFORE_CLEANING);
    }

    default Room markInUse(Room room){
        return save(room.markInUse());
    }

    default Room markBeforeCleaning(Room room){
        return save(room.markBeforeCleaning());
    }

    default Room markCleaning(Room room){
        return save(room.markCleaning());
    }

    default Room markReady(Room room){
        return save(room.markReady());
    }
}
