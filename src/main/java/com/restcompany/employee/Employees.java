package com.restcompany.employee;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface Employees extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByStatus(@Param("status") Status status);

    Integer countByStatus(@Param("status") Status status);

    default List<Employee> getAvailable() {
        return findByStatus(Status.FREE);
    }

    default boolean isAvailable() {
        if (countByStatus(Status.FREE) > 0) {
            return true;
        }
        return false;
    }

    default Employee markFree(Employee employee){
        return save(employee.markFree());
    }

    default Employee markBusy(Employee employee){
        return save(employee.markBusy());
    }
}
