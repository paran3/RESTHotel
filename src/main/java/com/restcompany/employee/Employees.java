package com.restcompany.employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
@Repository
public interface Employees extends PagingAndSortingRepository<Employee, Long> {

//    List<Employee> findByLastName(@Param("name") String name);

    @RestResource(rel = "lastname", path="lastname")
    Page<Employee> findByLastName(@Param("query") String query, Pageable page);
}
