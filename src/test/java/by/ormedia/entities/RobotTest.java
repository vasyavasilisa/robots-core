package by.ormedia.entities;

import java.lang.reflect.Field;
import java.util.Date;
import junit.framework.TestCase;

public class RobotTest extends TestCase {

	public void testSetName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Robot robot = new Robot();
		robot.setName("robot");
		Field field = robot.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals("Fields name didn't match", "robot", field.get(robot));
	}

	public void testSetDate() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Robot robot = new Robot();
		Date date = new Date();
		robot.setIssueDate(date);
		Field field = robot.getClass().getDeclaredField("issueDate");
		field.setAccessible(true);
		assertEquals("Fields date created didn't match", date, field.get(robot));
	}

	public void testGetName()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Robot robot = new Robot();
		Field field = robot.getClass().getDeclaredField("name");
		field.setAccessible(true);
		field.set(robot, "somename");
		assertEquals("Fields name didn't match", "somename", robot.getName());
	}

	public void testGetDate()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Robot robot = new Robot();
		Field field = robot.getClass().getDeclaredField("issueDate");
		field.setAccessible(true);
		Date date = new Date();
		field.set(robot, date);
		assertEquals("Fields date created didn't match", date, robot.getIssueDate());
	}
}