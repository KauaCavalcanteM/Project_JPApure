package exemplo.carros.modelo;

import jakarta.persistence.Entity; // permite usar o @Entity -> diz que a classe é uma tablea
import jakarta.persistence.GeneratedValue; // permite usar o @GeneratedValue -> ID gerado automaticamente
import jakarta.persistence.Id; // permite usar o @Id -> marca a chave primária
import jakarta.persistence.Table; // permite usar o @Table -> define o nome da tabela

@Entity // Diz ao hibernate: essa classe é uma tabela no banco
@Table(name = "modelos") // dizemos a qual tabela essa classe pertence
public class Modelo {
    @Id // Esse campo é uma chave primária
    @GeneratedValue // Gera o Id automaticamente
    private Long id;
    private String nome;
    private char status;

    //Construtor que setta o nome do modelo
    public Modelo(String nome,char status){
        this.nome = nome;
        this.status = status;
    }
    // construtor vazio obrigatório ao hibernate
    public Modelo(){

    }

    //Métodos:
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public char getStatus(){
        return status;
    }

    public void setStatus(char status){
        this.status = status;
    }
}
