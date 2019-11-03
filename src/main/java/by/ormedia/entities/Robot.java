package by.ormedia.entities;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import by.ormedia.robots.core.IRobot;
import by.ormedia.robots.core.ITask;

public class Robot implements Runnable, IRobot {

	private String name;
	private List<ITask> taskList;
	private int amountOfCompletedTasks;
	private Date dateCreated;
	private volatile boolean isExit;

	public Robot() {
		this.taskList = new LinkedList<>();
		new Thread(this).start();
	}

	public void run() {
		while (!isExit) {
			for (ITask task : this.taskList) {
				task.perform(this);
				if (task.equals("Die")) {
					isExit = true;
					break;
				}
			}
		}
	}

	@Override
	public void addNewTask(ITask task) {
		this.taskList.add(task);
	}

	@Override
	public void report(String arg0) {
		// TODO Auto-generated method stub

	}
}