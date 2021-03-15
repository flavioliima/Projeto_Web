package br.edu.cesmac.si.nolapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jornalista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJornalista;
    private String nome;
    private String email;
    private String biografia;

    public Jornalista(){

    }

    public Jornalista(Long idJornalista, String nome, String email, String biografia){
        this.idJornalista = idJornalista;
        this.nome = nome;
        this.email = email;
        this.biografia = biografia;
    }

    public Long getIdJornalista(){
        return idJornalista;

    }

    public void setIdJornalista(Long idJornalista){
        this.idJornalista = idJornalista;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
