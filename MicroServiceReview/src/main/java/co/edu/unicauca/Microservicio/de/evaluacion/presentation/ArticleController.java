/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.presentation;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.Microservicio.de.evaluacion.services.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ismos
 */
@RestController
@RequestMapping("/review/article")
public class ArticleController {

   private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/{articuloId}/asignar-evaluadores")
    public ResponseEntity<Article> asignarEvaluadores(@PathVariable String articuloId, @RequestBody List<Evaluator> evaluadores) {
            Article article = articleService.asignarEvaluadores(articuloId, evaluadores);
            return ResponseEntity.ok(article);

    }
}


