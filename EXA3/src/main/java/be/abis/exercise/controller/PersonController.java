package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {

	@Autowired 
	PersonService ps;
	
	@GetMapping("{id}")
    public Person findPerson(@PathVariable("id") int id){
    	return ps.findPerson(id);    	
    }
	
	@GetMapping("")
	public ArrayList<Person> getAllPersons(){
		return ps.getAllPersons();
	}
		
	@PostMapping("")
    public void addPerson(@RequestBody Person person){
    	try {
    		System.out.println("Person added : " +person.getPersonId());
			ps.addPerson(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") int id) {
		try {
			System.out.println("Person deleted : " +id);
			ps.deletePerson(id);
		} catch (PersonCanNotBeDeletedException e) {
			e.printStackTrace();
		}
    }
	
	@PutMapping("{id}")
    public void changePassword(@PathVariable("id") int id, @RequestBody Person person)  {
    	try {
    		System.out.println("pasword changed for " +id);
			ps.changePassword(ps.findPerson(id), person.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	@PostMapping("/login")
	public Person findPersonByLogin (@RequestBody Login login){
		System.out.println("search person with : " +login.getEmail() + " " +login.getPassword());
		Person user = ps.findPerson(login.getEmail(), login.getPassword());
		return user;
	}
	
	
}
