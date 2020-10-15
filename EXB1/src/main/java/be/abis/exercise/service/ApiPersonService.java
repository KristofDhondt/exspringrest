package be.abis.exercise.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;

import be.abis.exercise.model.Person;

@Service
public class ApiPersonService implements PersonService {
	
	@Autowired
	private RestTemplate restTemp;
	
	private String baseUri = "http://localhost:8084/exercise/api/persons";
	
	@Override
	public Person findPerson(int personId) {
	    Person p = restTemp.getForObject(baseUri + "/" +personId, Person.class);
		return p;
	}

	@Override
	public ArrayList<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findPerson(String emailAddress, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPerson(Person p) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
