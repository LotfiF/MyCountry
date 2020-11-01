package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.projet.modeles.Pays;
import com.projet.modeles.Region;

public class RegionDAO implements IRegionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() { 
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Region> recupererListeRegions() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Region").list();
	}
	
	@Transactional
	public void ajouterRegion(Region region) {
		Session session = sessionFactory.getCurrentSession();
		session.save(region);
	}

	@Transactional
	public void supprimerRegion(Region region) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(region);
	}
	
	@Transactional
	public Region trouverRegion(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Region) session.get(Region.class, id);
	}
	
	@Transactional
	public void updateRegion(Region region){
	Session session = sessionFactory.getCurrentSession();
	session.update(region);
	}
	
	@Transactional
	public List<Region> recupererListeRegionsParPays(Pays pays) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Region where pays = :pays");
		q.setParameter("pays", pays);
		return q.list();
	}
	
}