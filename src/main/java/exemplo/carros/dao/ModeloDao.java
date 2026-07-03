/*
classe DAO (Objeto de Acesso a Dados).
Ela é responsável por realizar as operações de persistência dos objetos da classes de entidades.
 */


package exemplo.carros.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import exemplo.carros.modelo.Modelo;

public class ModeloDao {
    private EntityManager em; // É quem executa o SQL

    public ModeloDao(EntityManager em){
        this.em = em;
    }

    public void Cadastrar(Modelo modelo){
        //persist -> INSERT no banco
        //Hibernate gera: INSERT INTO modelos (nome) VALUES (?)
        em.persist(modelo);
    }

    public void Atualizar(Modelo modelo){
        //merge -> UPDATE no banco
        // hibernate gera: UPDATE modelos set nome = ? WHERE id = ?
        this.em.merge(modelo);
    }

    public void remover(Modelo modelo){
        //Primeiro reatacha o objeto EntityManager
        modelo = em.merge(modelo);
        //remove -> DELETE no banco
        // hibernate gera: DELETE FROM modelos WHERE id =?
        this.em.remove(modelo);
    }

    /*
    Um ponto importante para destacarmos nesse código é a utilização de objeto “EntitityManager”
    que, de fato, é responsável pela persistência dos objetos. Além disso, no método “listarTodos”,
    utilizamos a JPQL para listar todos os modelos. Devemos perceber que o nome próximo da cláusula
    “FROM” é o do objeto e não da tabela.
     */
    public List<Modelo> listarTodos(){
        String jpql = "SELECT m FROM Modelo m"; // Modelos -> nome da classe java não da tabela
        return em.createQuery(jpql, Modelo.class).getResultList(); // Gera a query "jpql" da classe Modelo, e depois retorna em uma lista
        //Hibernate traduz para: M.id , M.nome FROM modelos m
    }
}
