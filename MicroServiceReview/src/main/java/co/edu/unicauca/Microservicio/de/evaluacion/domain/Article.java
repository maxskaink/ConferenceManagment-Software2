/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.domain;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 *
 * @author ismos
 */

@Entity
@Table(name = "Article")
public class Article {
     @Id
    private String id;
    private String name;
    private String idAuthor;
    private String keyWords;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Evaluator> Evaluadores;
   
   
    public String getId() {return id;}
    public String getName() {return name;}
    public String getIdAuthor() {return idAuthor;}
    public String getKeyWords() {return keyWords;}
    public List<Evaluator> getEvaluadores() {return Evaluadores;}
    
    public void setId(String id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setIdAuthor(String idAuthor) {this.idAuthor = idAuthor;}
    public void setKeyWords(String keyWords) {this.keyWords = keyWords;}                                                                                    
    public void setEvaluadores(List<Evaluator> Evaluadores) {this.Evaluadores = Evaluadores;}
    
 
    public Article(){

    }

    public Article(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public Article(String id, String name, String idAuthor, String keyWords, List<Evaluator> Evaluadores) {
        this.id = id;
        this.name = name;
        this.idAuthor = idAuthor;
        this.keyWords = keyWords;
        this.Evaluadores = Evaluadores;
    }
}

