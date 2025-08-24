package com.jpueyodev.dao;

import java.util.List;

import com.jpueyodev.Lawyer;

public interface LawyerDAO {

	public List<Lawyer> getLawyers();
	
	public void insertLawyer(Lawyer lawyer);
}
