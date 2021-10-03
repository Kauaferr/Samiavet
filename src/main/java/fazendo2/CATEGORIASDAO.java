package fazendo2;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

public class CATEGORIASDAO {
	private static EntityManager novoGerenciador;

	
	
	
	
	public static List<CATEGORIAS> buscarTodos() throws SQLException{
		try {
			novoGerenciador = JPAUtil.getEntityManager();
			novoGerenciador.getTransaction().begin();
			String jpql = "SELECT p FROM CATEGORIAS p";
			return  novoGerenciador.createQuery(jpql, CATEGORIAS.class).getResultList();
		
		}
		catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
		}finally {
			novoGerenciador.close();
		}
		return null;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
