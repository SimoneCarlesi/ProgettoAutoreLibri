package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;

@Stateless
public class AutoreDao {
	
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	public Autore get(int id) {
		return em.find(Autore.class, id);
	}

//	@Override
	public List<Autore> getAll() {
		return em.createNamedQuery("findAllAutors", Autore.class)
				.getResultList();
	}
	

//	@Override
	public void save(Autore t) { //GET
		em.persist(t);
	}
	
	//Questo metodo serve per salvare/sovrascrivere un istanza di padrone nel database
	public void save(String nome, String cognome, int id, int eta) {	 //POST	
		Autore autoreEsistente=em.find(Autore.class,id);
		if(autoreEsistente != null) {
			autoreEsistente.setNome(nome);
			autoreEsistente.setCognome(cognome);
			autoreEsistente.setEta(eta);
			em.merge(autoreEsistente);
		} else {
			Autore autoreToSave=new Autore();
			autoreToSave.setNome(nome);
			autoreToSave.setCognome(cognome);
			autoreToSave.setId(id);
			autoreToSave.setEta(eta);
			em.persist(autoreToSave);
		}
	}

//	@Override
	public void update(Autore t) {//
		em.merge(t);
	}

//	@Override
	public void delete(Autore t) {
		em.remove(t);
	}
}
