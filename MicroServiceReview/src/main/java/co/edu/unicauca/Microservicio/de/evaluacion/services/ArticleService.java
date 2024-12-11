/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.dao.ArticleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author ismos
 */
@Service
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleRepository ArticleDao;
    
    @Autowired
    private EvaluatorService evaluatorService;

    public Article asignarEvaluadores(String articuloId, List<Evaluator> evaluadoresSeleccionados) {
        // Obtener evaluadores disponibles
        List<Evaluator> evaluadoresDisponibles = evaluatorService.FindAvailable();

        // Validar que los evaluadores seleccionados estén disponibles
        boolean todosDisponibles = evaluadoresSeleccionados.stream()
            .allMatch(evaluadoresDisponibles::contains);

        if (!todosDisponibles) {
            throw new IllegalArgumentException("Algunos evaluadores seleccionados no están disponibles.");
        }

        // Validar número de evaluadores
        if (evaluadoresSeleccionados.size() < 2 || evaluadoresSeleccionados.size() > 5) {
            throw new IllegalArgumentException("El número de evaluadores debe estar entre 2 y 5.");
        }

        // Obtener el artículo
        Article articulo = ArticleDao.findById(articuloId)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

        // Asignar evaluadores al artículo
        articulo.setEvaluadores(evaluadoresSeleccionados);

        // Actualizar la lista de artículos de cada evaluador
        for (Evaluator evaluador : evaluadoresSeleccionados) {
            if (evaluador.getArticles() == null) {
                evaluador.setArticles(new ArrayList<>());
            }
            evaluador.getArticles().add(articulo);
        }

        // Guardar el artículo
        return ArticleDao.save(articulo);
    }
}

