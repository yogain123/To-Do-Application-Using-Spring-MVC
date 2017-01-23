package com.in28minutes.jee;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public Boolean isValid(String name , String password)
	{
		if(name.equals("yogi")&&password.equals("1234"))
			return true;
		else
			return false;
	}

}
