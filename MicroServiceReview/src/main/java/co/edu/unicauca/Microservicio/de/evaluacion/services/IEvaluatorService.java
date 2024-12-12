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
    /**
     *
     * @return all Evaluators
     */
    public List<Evaluator> findAll();

    /**
     *
     * @param id id to Evaluator
     * @return
     */
    public Evaluator findById(String id);

    /**
     *
     * @param evaluator evaluator to create
     * @return
     */
    public Evaluator create(Evaluator evaluator);

    /**
     *
     * @param id id of evaluator to update
     * @param evaluator entity evaluator for update
     * @return
     */
    public Evaluator update(String id, Evaluator evaluator);

    /**
     *
     * @param id id to evaluator to delete
     */
    public void deleteById(String id);

    /**
     *
     * @param evaluator Evaluator to save
     * @return
     */
    public Evaluator save(Evaluator evaluator);

    /**
     *
     * @param id id of Evaluator to see Article
     * @return
     */
    List<Article> getArticlesByEvaluatorId(String id);

    /**
     *
     * @return list Evaluatros find
     */
    List<Evaluator> FindAvailable();
}
