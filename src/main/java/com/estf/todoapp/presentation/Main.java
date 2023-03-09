package com.estf.todoapp.presentation;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.business.DefaultServices;
import com.estf.todoapp.dao.TodoDaoMemory;
import com.estf.todoapp.presentation.views.TodoJframe;
import com.gl.utils.XmlOperations;

public class Main {

	public Main() {
		//XmlOperations xmlOperations= new XmlOperations<Todo>(Todo.class);
		new TodoJframe();
	}
	public static void main(String[] args) {
		new Main();

	}

}
