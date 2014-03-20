package pjweb2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.dk.pjweb2.dao.UsuarioDAO;
import br.com.dk.pjweb2.entidade.Usuario;

public class TestUsuarioDao {

	@Test
	public void testSalvar() {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Priscila");
		usuario.setEmail("priscila@gmail.com");
		usuario.setSenha("123456");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.salvar(usuario);
		
		Assert.assertTrue(usuario.getId()!= null);
	}
	
	@Test
	public void testBuscaTodos(){
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscarTodos();
		Assert.assertTrue(lista.size()>0);
	}

}
