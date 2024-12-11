package co.edu.unicauca.Microservicio.de.evaluacion.presentation;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.Microservicio.de.evaluacion.services.IEvaluatorService;

@RestController 
@Component  
@RequestMapping("/evaluator") 
public class EvaluatorController { 
    @Autowired 
    IEvaluatorService evaluatorService; 

    @GetMapping
    public List<Evaluator> findAll() { 
        return evaluatorService.findAll(); 
    }
    @GetMapping("/disponibles")
    public List<Evaluator> findAvaible() { 
        return evaluatorService.FindAvailable();
    }
    @PostMapping
    public ResponseEntity<Evaluator> createEvent(@RequestBody Evaluator evaluator) {
        Evaluator createEvaluator = evaluatorService.create(evaluator);
        return ResponseEntity.ok(createEvaluator);
    }

    @GetMapping("/{id}") 
    public Evaluator getEvaluatortById(@PathVariable String id) { 
        return evaluatorService.findById(id); 
    }
        @GetMapping("/{id}/articles")
    public List<Article> getArticles(@PathVariable String id) {
        return evaluatorService.getArticlesByEvaluatorId(id);
    }
}
