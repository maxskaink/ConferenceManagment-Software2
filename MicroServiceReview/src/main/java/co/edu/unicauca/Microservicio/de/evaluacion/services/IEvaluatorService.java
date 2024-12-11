/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;

/**
 *
 * @author ismos
 */
import java.util.List;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
public interface IEvaluatorService {
    public List<Evaluator> findAll(); 
    public Evaluator findById(String id); 
    public Evaluator create(Evaluator evaluator); 
    public Evaluator update(String id, Evaluator evaluator); 
    public void deleteById(String id); 
    public Evaluator save(Evaluator evaluator);
    List<Article> getArticlesByEvaluatorId(String id);
    List<Evaluator> FindAvailable();
}
