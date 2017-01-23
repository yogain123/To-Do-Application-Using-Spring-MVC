package com.in28minutes.jee;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.todo.Todo;
import com.in28minutes.todo.TodoService;



@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	LoginService service;
	
	@Autowired
	TodoService serviceTodo;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String getLoginHandler(@RequestParam String name,@RequestParam String password,ModelMap model)
	{	
		
		boolean check = service.isValid(name,password);
		model.put("name", name);
		model.put("password", password);
		model.put("error", "Invalid Credentials");
		if(check==true)
			return "welcome";
		else
			return "login";
	}
	
	@RequestMapping(value="/list-todos" , method=RequestMethod.GET)
	public String getTodo(ModelMap model)
	{
		model.addAttribute("Todo",serviceTodo.retrieveTodos((String)model.get("name")));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todos" , method=RequestMethod.GET)
	public String addTodo(ModelMap model)
	{
		model.addAttribute("todo", new Todo(0, "yogi", "", new Date(), false));
		return "add-todos";
	}
	
	@RequestMapping(value="/add-todos" , method=RequestMethod.POST)
	public String seeTodo(ModelMap model,Todo todo)
	{
		serviceTodo.addTodo((String)model.get("name"), todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="/delete-todo" , method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id)
	{
		serviceTodo.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="/update-todo" , method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model)
	{
		Todo todo = serviceTodo.retrieveTodos(id);
		model.addAttribute("todo", todo);
		return "add-todos";
		
	}
	
	  @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	    public String updateTodo(ModelMap model,Todo todo)
	  {
	      
	        todo.setUser("yogi");
	        serviceTodo.updateTodo(todo);

	        model.clear();// to prevent request parameter "name" to be passed
	        return "redirect:/list-todos";
	    }


}
