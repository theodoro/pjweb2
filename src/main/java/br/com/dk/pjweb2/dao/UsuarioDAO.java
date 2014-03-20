package br.com.dk.pjweb2.dao;

import javax.persistence.EntityManager;

import br.com.dk.pjweb2.entidade.Usuario;
import br.com.dk.pjweb2.util.JPAUtil;

public class UsuarioDAO {

	EntityManager em;

	public UsuarioDAO(EntityManager em) {
		super();
		this.em = JPAUtil.getEntityManager();
	}

	public void salvar(Usuario usu) {

		try {
			em.getTransaction().begin();
			em.persist(usu);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		em.close();

	}
	
	public void alterar(Usuario usu){
		try{
			em.getTransaction().begin();
			em.persist(em.merge(usu));
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void remove(Usuario usu){
		try{
			em.getTransaction().begin();
			em.remove(usu);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		
		em.close();
	}

}
