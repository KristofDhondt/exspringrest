package be.abis.exercise.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
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
		Login login = new Login();
		login.setEmail(emailAddress);
		login.setPassword(passWord);
		Person p = restTemp.postForObject(baseUri+"/login",login, Person.class);
		return p;
	}

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		restTemp.delete(baseUri="/"+id);
		System.out.println("person deleted " +id);		
	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		// TODO Auto-generated method stub
		
	}
		
	
}
