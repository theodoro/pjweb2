package pjweb2;

import javax.persistence.EntityManager;

import br.com.dk.pjweb2.entidade.Usuario;
import br.com.dk.pjweb2.util.JPAUtil;


public class JPATeste {
	
	public static void main(String[] args){
		
		Usuario usu = new Usuario();
		EntityManager em = JPAUtil.getEntityManager();
		
		usu.setNome("Priscila Carvalho");
		usu.setEmail("priscila.soak@hotmail.com");
		usu.setSenha("123");
		
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		em.close();
	}

}
