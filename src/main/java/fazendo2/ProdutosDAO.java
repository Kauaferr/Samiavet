package fazendo2;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProdutosDAO {

	
	private static EntityManager novoGerenciador;
	
	
	public static String cadastrarProdutos(Produtos p)  {
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

	public  String consultar(Produtos p)  {
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
	public void removendo(Produtos p ) {
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
	public static List<Produtos> buscarNome(String nome){
		try {
		novoGerenciador = JPAUtil.getEntityManager();
		novoGerenciador.getTransaction().begin();
		String jpql = "SELECT p FROM Produtos p WHERE LOWER(p.nome) =  LOWER (:parametro) ";
		TypedQuery<Produtos> Query = novoGerenciador.createQuery(jpql, Produtos.class).setParameter("parametro" , nome );
		List<Produtos> lista = Query.getResultList();
		return lista;
		}
		catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
		}finally {
			novoGerenciador.close();
		}
		return null;
	}




	public static List<Produtos> buscarTodos() throws SQLException{
		try {
			novoGerenciador = JPAUtil.getEntityManager();
			novoGerenciador.getTransaction().begin();
			String jpql = "SELECT p FROM Produtos p";
			return  novoGerenciador.createQuery(jpql, Produtos.class).getResultList();
		
		}
		catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
		}finally {
			novoGerenciador.close();
		}
		return null;
	
	
	
	
	
	
	}
	
	public static List<Produtos> buscarId(Long id){
		try {
		novoGerenciador = JPAUtil.getEntityManager();
		novoGerenciador.getTransaction().begin();
		String jpql = "SELECT p FROM Produtos p WHERE p.id = :id ";
		TypedQuery<Produtos> Query = novoGerenciador.createQuery(jpql, Produtos.class).setParameter("nome" , id);
		List<Produtos> lista = Query.getResultList();
		return lista;
		}
		catch(Exception erro) {
			novoGerenciador.getTransaction().rollback();
		}finally {
			novoGerenciador.close();
		}
		return null;
	}
	
	
}
