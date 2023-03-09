package com.estf.todoapp.dao;

import java.util.List;

import com.estf.todoapp.beans.Todo;
import com.gl.utils.XmlOperations;

public class TodoDaoXml implements TodoDao{

	private List<Todo> todos;
	private XmlOperations<Todo> xmlOperations;
	public TodoDaoXml() {
		xmlOperations= new XmlOperations<Todo>(Todo.class);
		todos=xmlOperations.load("todos.xml");
	}
	@Override
	public Todo insert(Todo todo) {
		todos.add(todo);
		System.out.println(todo);
		if(xmlOperations.save("todos.xml", todos))
		return todo;
		
		return null;
	}

	@Override
	public Todo update(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo delete(Todo todo) {
		Todo element=get(todo.getId());
		if(element==null)
			return null;
		todos.remove(todo);
		if(xmlOperations.save("todos.xml", todos))
		return todo;
		
		return null;
	}

	@Override
	public Todo get(String id) {
		for(Todo element:todos)
			if(element.getId().equals(id))
				return element;
		return null;
	}

	@Override
	public List<Todo> getAll() {
		// TODO Auto-generated method stub
		return todos;
	}

}
