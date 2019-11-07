package by.ormedia.entities;


import java.sql.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class RobotTest extends TestCase {

	@Test
	public void testSetGetName() {
		Robot robot = new Robot();
		robot.setName("robot");
		assertEquals("Fields name didn't match", "robot", robot.getName());
	}

	@Test
	public void testSetGetDate() {
		Robot robot = new Robot();
        long millis = System.currentTimeMillis();  
        Date currentDate = new Date(millis);  
		robot.setIssueDate(currentDate);
		assertEquals("Fields date created didn't match", currentDate, robot.getIssueDate());
	}
}