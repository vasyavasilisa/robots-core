package by.ormedia.entities;

import java.sql.Date;
import java.util.LinkedList;
import java.util.Queue;

import by.ormedia.robots.core.IRobot;
import by.ormedia.robots.core.ITask;

public class Robot implements Runnable, IRobot {

	private String name;
	private Queue<ITask> taskList;
	private int numberOfTasks;
	private Date issueDate;
	private boolean isAlive = true;

	public Robot() {
		this.taskList = new LinkedList<>();
		new Thread(this).start();
	}

	public Robot(String name, Date date) {
		this.name = name;
		this.issueDate = date;
	}
	
	public void run() {
		while (isAlive) {
			for (ITask task : this.taskList) {
				task.perform(this);
				if (task.equals("Die")) {
					isAlive = false;
					break;
				}
			}
		}
	}

	@Override
	public synchronized void addNewTask(ITask task) {
		this.taskList.add(task);
	}

	@Override
	public void report(String arg0) {
		// TODO Auto-generated method stub

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date dateCreated) {
		this.issueDate = dateCreated;
	}
}