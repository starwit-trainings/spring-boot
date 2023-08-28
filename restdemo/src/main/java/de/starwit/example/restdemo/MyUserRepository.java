package de.starwit.example.restdemo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Long> {

    List<MyUser> findAll();
}
