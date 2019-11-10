package com.eklavya.database.databasedemo.jdbcDaoImpl;

import com.eklavya.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJDBCDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> getAllPerson(){
        return jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersonById(int id){
        return jdbcTemplate.queryForObject("Select * from Person where id = ?"
                , new Integer [] {id}
                , new PersonRowMapper());
    }

    public List<Person> getPersonByIdOrLocation(int id, String location){
        return jdbcTemplate.query("Select * from Person where id = ? or location = ?"
                , new Object [] {id, location}
                , new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deletePersonById(int id){
        return jdbcTemplate.update("Delete from Person where id = ?"
                , new Integer [] {id} );
    }

    public int insertPerson(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) "
                + "VALUES (?, ?, ?, ?)"
                , new Object [] {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())} );
    }
    public int updatePerson(Person person){
        return jdbcTemplate.update("Update Person "
                + "SET location = ? "
                + "WHERE id = ?"
                , new Object [] {person.getLocation(), person.getId()} );
    }
}