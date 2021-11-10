package servlet;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.LibroDao;
import dao.AutoreDao;
import model.Libro;
import model.Autore;


@Stateless

@Path("rest")
public class RestController {

	@Inject
	private AutoreDao autoreDao;
	
	@Inject
	private LibroDao libroDao;


	@Inject
	
	// --- http://localhost:8080/progettoejb/api/rest/all ---
	// http protocollo
	// 127.0.0.1 : dove risiede il mio server
	// 8080 porta default di esposizione protocollo application server
	// progettoEjb = nome progetto definito in maven
	// api = servlet
	// rest = ejb contenitore di servizi esposti
	// all = il nome del metodo
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("{id}") //variabile {}
	public Padrone getById(@PathParam("id") int id) {
		return padroneDao.get(id);
	}*/

	
	//ritorno di tutti i libri
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("getLibri") //variabile {}
	public List<Libro> getEvery(){
		return libroDao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("postAutore")
	public Autore insertAutore(Autore nuovoAutore) {
	autoreDao.save(nuovoAutore);
	return nuovoAutore;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("getAutori") //variabile {}
	public List<Autore> getEvryone() {
		return autoreDao.getAll();
	}
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("getAutori")
	public String insertAutore(
	@QueryParam("nome") String nome,
	@QueryParam("cognome") String cognome,
	@QueryParam("id") String id,
	@QueryParam("eta") String eta) {
	autoreDao.save(
	nome,
	cognome,
	Integer.parseInt(id),
	Integer.parseInt(eta));
	return "Insert finished with success!";
	}*/
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("generaTreAutori")
	public List<Autore> generaAutores(){
		AtomicInteger count = new AtomicInteger(1);
		Autore padrone1 = new Autore();
		List<Autore> autoreList = Arrays
				.asList(new Autore(),
						new Autore(),
						new Autore());
		autoreList.stream()
		.forEach(persona -> {
			persona.setNome("nome"+count.get());
			persona.setCognome("cognome"+count.getAndIncrement());

		});
		padrone1.setCognome("asd");
		padrone1.setNome("das");
		padrone1.setId(3);
		autoreList.stream()
		.forEach(persona ->{
			autoreDao.save(persona);
		});
		//


		//terzo inserimento illegale test
		return autoreList;
	}


}
