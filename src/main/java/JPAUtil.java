

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory entidade = Persistence.createEntityManagerFactory("cadastro");

	
	public JPAUtil() throws Exception {
		
	
	}
	public static EntityManager getEntityManager() {
		return entidade.createEntityManager();
	}


}
