package br.com.dk.pjweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dk.pjweb2.entidade.Usuario;
import br.com.dk.pjweb2.util.JPAUtil;

public class UsuarioDAO {

	EntityManager em;

	public UsuarioDAO() {
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos(){
		Query consulta = em.createQuery("select u from Usuario u");
		return consulta.getResultList();
	}
	
	public Usuario buscaPorId(Long id){
		return em.find(Usuario.class, id);
		
	}

}
