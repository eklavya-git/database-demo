package com.eklavya.database.databasedemo;

import com.eklavya.database.databasedemo.entity.Person;
import com.eklavya.database.databasedemo.jdbcDaoImpl.PersonJDBCDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.PersistenceContext;
import java.util.Date;

@PropertySource("classpath:/myProperty.properties") //This is used to include custom properties files.
@SpringBootApplication
public class SpringJPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJDBCDao personJdbcDao;

	@Value("${random}")
	private String random;

	@Value("${test}")
	private String test;

	public static void main(String[] args) {

		SpringApplication.run(SpringJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person with id: 100001 -> {}", personJdbcDao.getPersonById(100001));
		logger.info("Random Value: {}", random);
		logger.info("Tese Value: {}", test);
		/*logger.info("All Persons -> {}", personJdbcDao.getAllPerson());
		logger.info("Person with id: 100003 Or location: Bengaluru -> {}", personJdbcDao.getPersonByIdOrLocation(100004, "Bengaluru"));
		logger.info("Deleting Person with Id: 100005. Total No of rows affected -> {}", personJdbcDao.deletePersonById(100005));
		logger.info("Inserting person with id: 100005. {} person/s inserted",
				personJdbcDao.insertPerson(new Person(100005, "Ram Gotur", "Hyderabad", new Date("12 Feb 1980"))));
		logger.info("Updating location for person with Id: 100003 to Bangalore. {} person/s updated",
				personJdbcDao.updatePerson(new Person(100003, "Rachit Boss", "Bangalore", new Date("23 Mar 1988"))));*/
	}
}
