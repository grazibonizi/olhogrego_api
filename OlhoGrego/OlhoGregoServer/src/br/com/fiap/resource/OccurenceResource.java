package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.fiap.dao.OccurenceDAO;
import br.com.fiap.dao.impl.OccurenceDAOImpl;
import br.com.fiap.entity.Occurence;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/occurence")
public class OccurenceResource {

private OccurenceDAO dao;
	
//Construtor para inicializar o DAO
	public OccurenceResource() {
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response cadastrar(String json){
		Gson gson = new GsonBuilder()
				   .setDateFormat("yyyy-MM-dd HH:mm:ss").create();//yyyy-MM-dd'T'HH:mm:ssXXX
		//Transformar o JSON em um objeto Occurence
		Occurence occ= gson.fromJson(json, Occurence.class);
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		try {
			
			dao = new OccurenceDAOImpl(em);
			dao.inserir(occ);
			em.close();
			//HTTP code 201 -> Created
			return Response.status(201).build();
		} catch (DBException e) {
			e.printStackTrace();
			em.close();
			return Response.status(500).build();
		}		
	}
}
