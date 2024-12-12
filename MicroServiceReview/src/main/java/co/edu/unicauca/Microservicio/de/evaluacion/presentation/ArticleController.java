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
@RequestMapping("/article") 
public class ArticleController {

   private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/{articuloId}/asignar-evaluadores")
    public ResponseEntity<Article> asignarEvaluadores(@PathVariable String articuloId, @RequestBody List<Evaluator> evaluadores) {
<<<<<<< HEAD

            Article article = articleService.asignarEvaluadores(articuloId, evaluadores);
            return ResponseEntity.ok(article);

=======
        try {
            Article article = articleService.asignarEvaluadores(articuloId, evaluadores);
            return ResponseEntity.ok(article);
        } catch (IllegalArgumentException e) {
            // Manejar errores específicos de validación
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            // Manejar errores de no encontrado o internos
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
    }
}


