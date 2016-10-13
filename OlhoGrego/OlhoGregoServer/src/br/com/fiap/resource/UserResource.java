package br.com.fiap.resource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.dao.impl.UserDAOImpl;
import br.com.fiap.entity.User;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/user")
public class UserResource {

private UserDAO dao;
			
	//Construtor para inicializar o DAO
	public UserResource() {
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN+";charset=utf-8")
	public String listar(){
		//Recuperar todas as agencias cadatradas no banco 
		Calendar texto = Calendar.getInstance();
		//Retorna o Array JSON 
		return texto.toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response cadastrar(String json){
		Gson gson = new GsonBuilder()
				   .setDateFormat("yyyy-MM-dd HH:mm:ss").create();//yyyy-MM-dd'T'HH:mm:ssXXX
		//Transformar o JSON em um objeto USER
		User user= gson.fromJson(json, User.class);
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		try {
			
			dao = new UserDAOImpl(em);
			dao.inserir(user);
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
