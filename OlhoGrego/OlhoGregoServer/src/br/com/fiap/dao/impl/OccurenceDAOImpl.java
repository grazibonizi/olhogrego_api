package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.OccurenceDAO;
import br.com.fiap.entity.Occurence;

public class OccurenceDAOImpl extends GenericDAOImpl<Occurence, Integer> implements OccurenceDAO{

	public OccurenceDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
