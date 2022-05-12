package com.restcompany.employee;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface Employees extends PagingAndSortingRepository<Employee, Long> {

    Boolean isAvailable();

    List<Employee> available();

    List<Employee> findByStatus(@Param("status") Status status);
}
