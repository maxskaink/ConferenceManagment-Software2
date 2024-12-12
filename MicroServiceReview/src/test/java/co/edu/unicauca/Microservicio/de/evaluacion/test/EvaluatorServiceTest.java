/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.test;

/**
 *
 * @author ismos
 */

import co.edu.unicauca.Microservicio.de.evaluacion.dao.EvaluatorRepository;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.services.EvaluatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EvaluatorServiceTest {

    @Mock
    private EvaluatorRepository evaluatorRepository;

    @InjectMocks
    private EvaluatorService evaluatorService;

    @Test
    public void testCreateEvaluator() {
        // Crear un evaluador de prueba
        Evaluator evaluator = new Evaluator("1","Evaluador 1", "evaluador1@example.com");

        // Simular el comportamiento del repositorio
<<<<<<< HEAD
        when(evaluatorRepository.saveEvaluator(evaluator)).thenReturn(evaluator);
=======
        when(evaluatorRepository.save(evaluator)).thenReturn(evaluator);
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330

        // Llamar al método del servicio
        Evaluator createdEvaluator = evaluatorService.create(evaluator);

        // Verificar que el evaluador se haya creado correctamente
        assertEquals("Evaluador 1", createdEvaluator.getName());
        assertEquals("evaluador1@example.com", createdEvaluator.getEmail());
    }

    @Test
    public void testGetArticlesByEvaluatorId() {
        // Crear un evaluador y algunos artículos de prueba
        Evaluator evaluator = new Evaluator("1","Evaluador 1", "evaluador1@example.com");
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("1","Artículo 1"));
        articles.add(new Article("2","Artículo 2"));
        evaluator.setArticles(articles);

        // Simular el comportamiento del repositorio
<<<<<<< HEAD

=======
        when(evaluatorRepository.findById("evaluador1")).thenReturn(java.util.Optional.of(evaluator));
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330

        // Llamar al método del servicio
        List<Article> retrievedArticles = evaluatorService.getArticlesByEvaluatorId("evaluador1");

        // Verificar que los artículos se hayan recuperado correctamente
        assertEquals(2, retrievedArticles.size());
        assertEquals("Artículo 1", retrievedArticles.get(0).getName());
        assertEquals("Artículo 2", retrievedArticles.get(1).getName());
    } 
}
