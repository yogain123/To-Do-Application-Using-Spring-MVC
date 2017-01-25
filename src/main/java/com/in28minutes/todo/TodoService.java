package com.in28minutes.todo;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
@Service
public class TodoService {
	
	static ArrayList<Todo> todos = new ArrayList<>();
	int count = 3;
	
	static
	{
		 todos.add(new Todo(1, "yogi", "Learn Spring MVC", new Date(),false));
	     todos.add(new Todo(2, "yogi", "Learn Struts", new Date(), false));
	     todos.add(new Todo(3, "yogi", "Learn Hibernate", new Date(),false));
	}
	
	public void addTodo(String name,String desc,Date targetDate,boolean isDone)
	{
		todos.add(new Todo(++count,name,desc,targetDate,isDone));
	}
	
	
	public void deleteTodo(int id) 
	{
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext())
        {
            Todo todo = iterator.next();
            if (todo.getId() == id) 
            {
                iterator.remove();
            }
        }
    }
	
	public ArrayList<Todo> retrieveTodos(String user)
	{
		ArrayList<Todo> filteredTodos = new ArrayList<>();
		for(Todo z : todos)
		{
			if(z.getUser().equals(user))
				filteredTodos.add(z);
		}
		
		return filteredTodos;
	}
	
	public Todo retrieveTodos(int id)
	{
		//ArrayList<Todo> filteredTodos = new ArrayList<>();
		for(Todo z : todos)
		{
			if(z.getId()==id)
				return z;
		}
		
		return null;
	}
	
	
	 public void updateTodo(Todo todo) {
	        todos.remove(todo);
	        todos.add(todo);
	    }

}
