/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.dao.EvaluatorRepository;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author ismos
 */
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluatorService implements IEvaluatorService {
    @Autowired
    private EvaluatorRepository evaluatorRepository;
    
    public List<Evaluator> findAll() {
        return evaluatorRepository.getAllEvaluators();
    }

    public Evaluator findById (String id) {
        Evaluator evaluatorOptional = evaluatorRepository.getEvaluator(id);
        if(evaluatorOptional==null)
            return null;
        return evaluatorOptional;

    }


    public Evaluator create(Evaluator evaluator) {
        return evaluatorRepository.saveEvaluator(evaluator);
    }

    public Evaluator update(String id, Evaluator evaluator) {

        return evaluatorRepository.UpdateEvaluator(id, evaluator);
    }

    public void deleteById(String id) {
        evaluatorRepository.deleteEvaluator(id);
    }

    public Evaluator save(Evaluator evaluator) {
        return evaluatorRepository.saveEvaluator(evaluator);
    }

    public List<Article> getArticlesByEvaluatorId(String id) {
        Evaluator evaluator = findById(id);
        return evaluator.getArticles();
    }
      public List<Evaluator> FindAvailable() {
        // Obtener todos los evaluadores
        List<Evaluator> todosEvaluadores = findAll();
        
        // Filtrar evaluadores con menos de 3 artículos
        return todosEvaluadores.stream()
            .filter(evaluador -> evaluador.getArticles() == null || evaluador.getArticles().size() < 3)
            .collect(Collectors.toList());
    }
 }