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
<<<<<<< HEAD
        return evaluatorRepository.getAllEvaluators();
    }

    public Evaluator findById (String id) {
        Evaluator evaluatorOptional = evaluatorRepository.getEvaluator(id);
        if(evaluatorOptional==null)
            return null;
        return evaluatorOptional;

=======
        return evaluatorRepository.findAll();
    }

    public Evaluator findById (String id) {
        Optional<Evaluator> evaluatorOptional = evaluatorRepository.findById(id);
        return evaluatorOptional.orElse(null);
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
    }


    public Evaluator create(Evaluator evaluator) {
<<<<<<< HEAD
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
=======
        return evaluatorRepository.save(evaluator);
    }

    public Evaluator update(String id, Evaluator evaluator) {
        if (evaluatorRepository.existsById(id)) {
            evaluator.setId(id);
            return evaluatorRepository.save(evaluator);
        }
        return null;
    }

    public void deleteById(String id) {
        evaluatorRepository.deleteById(id);
    }

    public Evaluator save(Evaluator evaluator) {
        return evaluatorRepository.save(evaluator);
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
    }

    public List<Article> getArticlesByEvaluatorId(String id) {
        Evaluator evaluator = findById(id);
<<<<<<< HEAD
        return evaluator.getArticles();
=======
        return evaluator != null ? evaluator.getArticles() : Collections.emptyList();
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
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


