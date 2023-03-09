package com.estf.todoapp.beans;

import java.util.Random;

public class Todo {
	private String id;
	private String title;
	private boolean completed;
	
	
	public Todo() {
		super();
		Random r =new Random();
		this.id = r.nextInt(1000000)+"";
	}
	public Todo(String title, boolean completed) {
		super();
		Random r =new Random();
		this.id = r.nextInt(1000000)+"";
		this.title = title;
		this.completed = completed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public boolean getCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
	
}
