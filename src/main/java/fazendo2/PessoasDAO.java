package fazendo2;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PessoasDAO {
	
	
	private static EntityManager novoGerenciador;
	
	
public static String cadastrarPessoas(Pessoas p)  {
	try {
	novoGerenciador = JPAUtil.getEntityManager();
	novoGerenciador.getTransaction().begin();
	novoGerenciador.persist(p);
	novoGerenciador.getTransaction().commit();
	}catch(Exception erro) {
		if(novoGerenciador.isOpen)){
		novoGerenciador.getTransaction().rollback();
		erro.printStackTrace();
		}
	}finally {
		if(novoGerenciador.isOpen)){

		novoGerenciador.close();
		}
	}
	return "index2";
	}
public static String cadastrarCategoria(CATEGORIAS p)  {
	try {
	novoGerenciador = JPAUtil.getEntityManager();
	novoGerenciador.getTransaction().begin();
	novoGerenciador.persist(p);
	novoGerenciador.getTransaction().commit();
	}catch(Exception erro) {
		novoGerenciador.getTransaction().rollback();
		erro.printStackTrace();
	}finally {
		System.out.println("hellothere");

		novoGerenciador.close();

	}
	return "index2";
	}
public static String consultar(Pessoas p)  {
	try {
		novoGerenciador = JPAUtil.getEntityManager();
		novoGerenciador.getTransaction().begin();
		novoGerenciador.merge(p);
		novoGerenciador.getTransaction().commit();
		}catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
			erro.printStackTrace();
		}finally {
			System.out.println("hellothere");

			novoGerenciador.close();

		}
	return "index2";
	}
public static void removendo(Pessoas p ) {
	try {
		novoGerenciador = JPAUtil.getEntityManager();
		novoGerenciador.getTransaction().begin();
		p = novoGerenciador.merge(p);
		novoGerenciador.remove(p);
		novoGerenciador.getTransaction().commit();
		}catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
			erro.printStackTrace();
		}finally {
			System.out.println("hellothere");

			novoGerenciador.close();

		}
		

}
public static EntityManager retorna() {
	
	return novoGerenciador;
	
}
public static List<Pessoas> buscarNome(String nome){
	try {
	novoGerenciador = JPAUtil.getEntityManager();
	novoGerenciador.getTransaction().begin();
	String jpql = "SELECT p FROM Pessoas p WHERE p.nome = :nome ";
	TypedQuery<Pessoas> Query = novoGerenciador.createQuery(jpql, Pessoas.class).setParameter("nome" , nome);
	List<Pessoas> lista = Query.getResultList();
	return lista;
	}
	catch(Exception erro) {
		novoGerenciador.getTransaction().rollback();
	}finally {
		novoGerenciador.close();
	}
	return null;
}




public static List<Pessoas> buscarTodos() throws SQLException{
	try {
		novoGerenciador = JPAUtil.getEntityManager();
		novoGerenciador.getTransaction().begin();
		String jpql = "SELECT p FROM Pessoas p";
		return  novoGerenciador.createQuery(jpql, Pessoas.class).getResultList();
	
	}
	catch(Exception erro) {
		novoGerenciador.getTransaction().rollback();
	}finally {
		novoGerenciador.close();
	}
	return null;
}








}
