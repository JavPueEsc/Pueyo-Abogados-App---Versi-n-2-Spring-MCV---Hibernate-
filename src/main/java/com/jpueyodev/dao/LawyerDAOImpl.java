package com.jpueyodev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpueyodev.Lawyer;

@Repository
public class LawyerDAOImpl implements LawyerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true)
	public List<Lawyer> getLawyers() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Transacción activa: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		return session.createQuery("FROM Lawyer",Lawyer.class).list();
	}

	@Override
	@Transactional
	public void insertLawyer(Lawyer lawyer) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Transacción activa: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		session.persist(lawyer);
	}

	@Override
	@Transactional
	public Lawyer getLawyerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Lawyer lawyer= session.find(Lawyer.class, id);
		return lawyer;
	}

	@Override
	@Transactional
	public void deleteLawyer(int id) {
		Session session = sessionFactory.getCurrentSession();
		var lawyer = session.find(Lawyer.class, id);
		session.remove(lawyer);
	}

}
