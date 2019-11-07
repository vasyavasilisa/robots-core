package by.ormedia.entities;

import java.util.Date;
import junit.framework.TestCase;

public class RobotTest extends TestCase {

	public void testSetGetName() {
		Robot robot = new Robot();
		robot.setName("robot");
		assertEquals("Fields name didn't match", "robot", robot.getName());
	}

	public void testSetGetDate() {
		Robot robot = new Robot();
		Date date = new Date();
		robot.setIssueDate(date);
		assertEquals("Fields date created didn't match", date, robot.getIssueDate());
	}
}