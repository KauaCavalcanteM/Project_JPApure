package exemplo.carros.testes;
import java.util.List;
import jakarta.persistence.EntityManager;
import exemplo.carros.modelo.Modelo;
import exemplo.carros.dao.ModeloDao;
import exemplo.carros.util.JPAUtil;

public class Testes {
    public static void main(String[] args) {
        cadastrarModelos();
        listarTodosModelos();
    }

    private static void cadastrarModelos(){
        //Inicia o EntityManager
        EntityManager em = JPAUtil.getEntityManager(); //return FACTORY.createEntityManager()
        ModeloDao modeloDao = new ModeloDao(em); // Cria um objeto do tipo modeloDao e adiciona como parametro do construtor o em(entitymanager)
        // Inicia operação no banco
        em.getTransaction().begin();
        //Hibernate: Insert INTO modelos (nome) VALUES ('Hatch')
        modeloDao.Cadastrar(new Modelo("Hatch",'1'));
        //Hibernate: Insert INTO (nome) VALUES('Sedan')
        modeloDao.Cadastrar(new Modelo("Sedan",'0'));
        // confirma tudo no banco
        em.getTransaction().commit();
        // fecha o caixa
        em.close();
        System.out.println("*** Cadastro com sucesso dos modelos de carro ***");
    }

    private static void listarTodosModelos(){
        EntityManager em = JPAUtil.getEntityManager();
        ModeloDao modeloDao = new ModeloDao(em);
        List<Modelo> lstModelo = modeloDao.listarTodos();
        System.out.println("*** Resultado da consulta dos modelos ***");

        for(Modelo m : lstModelo){
            System.out.println("id: " + m.getId() +"; nome: " +m.getNome() + "; status: " + m.getStatus());
        }

        em.close();
    }
}
