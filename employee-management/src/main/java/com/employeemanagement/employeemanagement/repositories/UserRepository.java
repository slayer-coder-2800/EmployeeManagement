package com.employeemanagement.employeemanagement.repositories;

import com.employeemanagement.employeemanagement.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
