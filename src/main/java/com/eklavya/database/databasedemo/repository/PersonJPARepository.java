package com.eklavya.database.databasedemo.repository;

import com.eklavya.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person getPersonById(int id){
        try{
            return entityManager.find(Person.class, id);
        }catch(Exception ex){
            return null;
        }
    }
}