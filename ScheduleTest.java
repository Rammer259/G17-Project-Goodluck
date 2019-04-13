import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;

import java.time.LocalTime;

public class ScheduleTest{
	
	LocalTime startMorning = LocalTime.parse("08:00");
	LocalTime startEvening = LocalTime.parse("16:00");
	LocalTime startOvernight = LocalTime.parse("00:00");
	
	@Test
	public void test_isWorkingMorning(){
		
		Schedule s = new Schedule();
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		LocalTime local = LocalTime.now();
		
		boolean actual = s.isWorking(e);
		
		boolean expected = s.isBetween(local, startMorning, startEvening);
		
		assertEquals("Checking if employee is working according to local time.", expected, actual);
	}
	
	@Test
	public void test_isWorkingEvening(){
		
		Schedule s = new Schedule();
		Employee e = new Employee("Bob", "Smith", "Janitor", "e", "12345", "123456897");
		
		LocalTime local = LocalTime.now();
		
		boolean actual = s.isWorking(e);
		
		boolean expected = s.isBetween(local, startEvening, startOvernight);
		
		assertEquals("Checking if employee is working according to local time.", expected, actual);
	}
	
	@Test
	public void test_isWorkingOvernight(){
		
		Schedule s = new Schedule();
		Employee e = new Employee("Bob", "Smith", "Guard", "o", "55555", "123456798");
		
		LocalTime local = LocalTime.now();
		
		boolean actual = s.isWorking(e);
		
		boolean expected = s.isBetween(local, startOvernight, startMorning);
		
		assertEquals("Checking if employee is working according to local time.", expected, actual);
	}
	
}