package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.EntityNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	private Class<T> classe;

	@SuppressWarnings("unchecked")//Tira o amarelinho
	public GenericDAOImpl(EntityManager em) {		
		this.em = em;
		this.classe = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir(T entidade) throws DBException {
		try{
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw new DBException("Cadastro não realizado");
		}
	}

	@Override
	public void alterar(T entidade) throws DBException {
		try{
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw new DBException("Alteração não realizada");
		}
	}

	@Override
	public void excluir(K chave) throws DBException, EntityNotFoundException {
		T entidade = buscar(chave);		
		try{
			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
		}catch(Exception e ){
			e.printStackTrace();
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw new DBException("Exclusão não realizada");
		}
	}

	@Override
	public T buscar(K chave) throws EntityNotFoundException {
		T entidade = em.find(classe, chave);
		if (entidade == null){
			throw new EntityNotFoundException("Entidade não encontrada");
		}
		return entidade;
	}
	
	@Override
	public List<T> listar() {
		TypedQuery<T> query = em.createQuery(
				"from " + classe.getName(),classe);
		return query.getResultList();
	}

}



