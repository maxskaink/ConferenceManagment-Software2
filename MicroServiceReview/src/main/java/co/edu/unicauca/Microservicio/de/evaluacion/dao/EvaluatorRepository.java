/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.dao;
import org.springframework.stereotype.Repository;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismos
 */
@Repository 
public class EvaluatorRepository implements  IEvaluatorsRepository{
    private final List<Evaluator> evaluators;
    public EvaluatorRepository() {
        evaluators = new ArrayList<Evaluator>();
    }

    @Override
    public Evaluator getEvaluator(String id) {
        for(Evaluator evaluator : evaluators) {
            if(evaluator.getId().equals(id)) {
                return evaluator;
            }
        }
        return null;
    }

    @Override
    public List<Evaluator> getAllEvaluators() {
        return evaluators;
    }

    @Override
    public Evaluator saveEvaluator(Evaluator evaluator) {
        if(evaluators.add(evaluator))
            return evaluator;
        return null;
    }

    @Override
    public Evaluator deleteEvaluator(String id) {
        for (int i = 0; i < evaluators.size(); i++) {
            Evaluator evaluator = evaluators.get(i);
            if (evaluator.getId().equals(id)) {
                evaluators.remove(i); // Elimina el evaluador de la lista
                return evaluator;    // Retorna el evaluador eliminado
            }
        }
        return null; // Si no se encuentra el evaluador, retorna null
    }

    @Override
    public Boolean Exist(String id) {
        if(getEvaluator(id) != null) {
            return true;
        };
        return false;
    }
    @Override
    public Evaluator UpdateEvaluator(String id, Evaluator updatedEvaluator){
        for(Evaluator evaluator : evaluators) {
            for (int i = 0; i < evaluators.size(); i++) {
                Evaluator currentEvaluator = evaluators.get(i);
                if (currentEvaluator.getId().equals(id)) {
                    currentEvaluator.setArticles(updatedEvaluator.getArticles());
                    evaluators.set(i, updatedEvaluator);
                    return updatedEvaluator; // Devuelve el evaluador actualizado
                }
            }
        }
        return null; // Si no se encontró, devuelve null
    }
}
