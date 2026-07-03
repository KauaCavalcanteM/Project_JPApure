package exemplo.carros.util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // Lê o persistence.xml
    // Conecta com o H2
    // Mapeia o Modelo.java, verifica as entidades(@Entity)
    //Cria as tabelas(hblm2ddl.auto=update)
    //fica pronto para criar EntityManagers
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("carros-pu"); // Esse carros-pu é a unidade de persistência que definimos no arquivo "persistence.xml"

    public static EntityManager getEntityManager(){
        //Jpa cria um objeto que sabe:
        //executar INSERT -> em.persist()
        //executar UPDATE -> em.merge()
        //executar DELETE -> em.remove()
        //executar SELECT -> em.find() ou em.creteQuery()
        //gerenciar transações -> em.getTransaction()
        return FACTORY.createEntityManager();
    }
}
