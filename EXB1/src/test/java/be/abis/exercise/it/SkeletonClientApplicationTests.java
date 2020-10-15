package be.abis.exercise.it;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.ApiPersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkeletonClientApplicationTests {
	
	@Autowired
	ApiPersonService apiPersServ;
	
	@Test
	public void contextLoads() {
	}
	       
    @Test
    public void person1isJohn() {
    	Person p = apiPersServ.findPerson(1);
    	System.out.println ("Person found is : " +p.getFirstName());
    	assertEquals("John",p.getFirstName());        
    }

}
