package br.com.dk.pjweb2.teste;

import javax.persistence.EntityManager;

import br.com.dk.pjweb2.entidade.Usuario;
import br.com.dk.pjweb2.util.JPAUtil;

public class JPATeste {
	
	public static void main(String[] agrs){
		
		Usuario usu = new Usuario();
		EntityManager em = JPAUtil.getEntityManager();
		
		usu.setNome("Bruno Aquino");
		usu.setEmail("theodorodeaquino@gmail.com");
		usu.setSenha("qwe123");
		
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		
		em.close();
	}

}
