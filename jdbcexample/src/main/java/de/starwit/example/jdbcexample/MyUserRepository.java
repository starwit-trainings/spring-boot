package de.starwit.example.jdbcexample;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Long> {

    List<MyUser> findAll();
    /*
     * TODO functions for
     * find all users with mail from domain
     * Find all users that has a name starting with g
     */
}
