package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Dummy;



public interface UserRepository extends CrudRepository<Dummy,Integer> {

}
