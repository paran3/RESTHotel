package com.restcompany.room;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Rooms", path = "rooms")
public interface Rooms extends PagingAndSortingRepository<Room,Integer> {

    List<Room> findByStatus(@Param("status") Status status);
}
