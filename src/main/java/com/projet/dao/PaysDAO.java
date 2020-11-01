package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.projet.modeles.Pays;

public class PaysDAO implements IPaysDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() { 
		return sessionFactory; 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Pays> recupererListePays() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Pays").list();		
	}

	@Transactional
	public void ajouterPays(Pays pays) {
		Session session = sessionFactory.getCurrentSession();
		session.save(pays);
	}

	@Transactional
	public void supprimerPays(Pays pays) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(pays);
	}
	
	@Transactional
	public Pays trouverPays(int idPays) {
		Session session = sessionFactory.getCurrentSession();
		return (Pays) session.get(Pays.class, idPays);
	}
	
	@Transactional
	public Pays trouverPaysParNom(String nomPays) {
		Session session = sessionFactory.getCurrentSession();
		return (Pays) session.get(Pays.class, nomPays);
	}
	
	@Transactional
	public void updatePays(Pays pays){
	Session session = sessionFactory.getCurrentSession();
	session.update(pays);
	}

}
