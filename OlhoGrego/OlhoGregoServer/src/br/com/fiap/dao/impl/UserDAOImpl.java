package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.entity.User;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	public UserDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
