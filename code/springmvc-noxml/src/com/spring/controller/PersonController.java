package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.entity.Person;
import com.spring.util.ContextGetter;

public class PersonController implements Controller {
	
	 Person person;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		person = (Person) ContextGetter.getBean("person");
		ModelAndView m = new ModelAndView();
		m.addObject(person);
		m.setViewName("person");
		
		return m;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
