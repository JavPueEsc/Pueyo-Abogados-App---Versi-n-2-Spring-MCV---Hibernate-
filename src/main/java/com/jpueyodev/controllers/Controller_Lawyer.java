package com.jpueyodev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jpueyodev.Lawyer;
import com.jpueyodev.dao.LawyerDAO;

@Controller
public class Controller_Lawyer {

	@Autowired
	private LawyerDAO lawyerDAO;
	
	@GetMapping("lawyers")
	public String LawyerList(Model modelo) {
		System.out.println("Entrando en listado de abogados");
		
		List<Lawyer> lawyers = lawyerDAO.getLawyers();
		modelo.addAttribute("lawyers", lawyers);
		
		return "Lawyers-list";
	}
}
