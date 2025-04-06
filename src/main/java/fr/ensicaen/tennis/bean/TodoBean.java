package fr.ensicaen.tennis.bean;

import fr.ensicaen.tennis.persistence.Database;
import fr.ensicaen.tennis.persistence.TodoEntity;

import java.util.List;

public class TodoBean {
	private Database database;
	public TodoBean() {
		database = Database.getInstance();
	}

	public List<TodoEntity> getTodoList() {
		return database.listTodo();
	}
}
