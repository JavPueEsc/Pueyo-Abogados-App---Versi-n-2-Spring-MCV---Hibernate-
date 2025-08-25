package com.jpueyodev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpueyodev.Lawyer;
import com.jpueyodev.dao.LawyerDAO;

@Controller
@RequestMapping("/lawyers")
public class Controller_Lawyer {

	@Autowired
	private LawyerDAO lawyerDAO;
	
	@GetMapping
	public String LawyerList(Model modelo) {
		System.out.println("Entrando en listado de abogados");
		
		List<Lawyer> lawyers = lawyerDAO.getLawyers();
		modelo.addAttribute("lawyers", lawyers);
		
		return "Lawyers-list";
	}
	
	@GetMapping("/new") 
	public String showLawyerInsertForm(Model model) {
		var lawyer = new Lawyer();
		model.addAttribute("modo", "insert");
		model.addAttribute("lawyer", lawyer);
		return "Lawyers-form";
	}
	
	@PostMapping
	public String insertLawyer(@ModelAttribute("lawyer") Lawyer lawyer) {
		lawyerDAO.insertLawyer(lawyer);
		return "redirect:/lawyers";
	}
	
	@GetMapping("/details") 
	public String showLawyerDetails(@RequestParam("lawyerId") int id, Model model) {
		var lawyer = lawyerDAO.getLawyerById(id);
		model.addAttribute("modo", "show");
		model.addAttribute("lawyer", lawyer);
		return "lawyers-details";
	}
	
	@PostMapping("/deleteLawyer")
	public String deleteLawyer(@RequestParam("lawyerId") int id) {
		lawyerDAO.deleteLawyer(id);
		return "redirect:/lawyers";
	}
	
	@GetMapping("/showLawyerUpdateForm") 
	public String showLawyerUpdateForm(@RequestParam("lawyerId") int id, Model model) {
		var lawyer = lawyerDAO.getLawyerById(id);
		model.addAttribute("modo", "update");
		model.addAttribute("lawyer",lawyer);
		return "Lawyers-form";
	}
	
	@PostMapping("/updateLawyer")
	public String updateLawyer(@ModelAttribute("lawyer")Lawyer lawyer) {
		lawyerDAO.updateLawyer(lawyer);
		return "redirect:/lawyers";
	}
}
