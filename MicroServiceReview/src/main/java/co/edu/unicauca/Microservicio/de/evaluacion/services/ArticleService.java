/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;
<<<<<<< HEAD
import ch.qos.logback.classic.boolex.IEvaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.dao.IArticleRepository;
=======
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
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
<<<<<<< HEAD
    private IArticleRepository ArticleDao;

    
    @Autowired
    private IEvaluatorService evaluatorService;

    /**
     *
     * @param evaluadoresDisponibles evaluators to repository
     * @param evaluadoresSeleccionados evaluators to validate
     * @return true = validate, false =  no validate
     */
    public boolean  validateEvaluator(List<Evaluator> evaluadoresDisponibles,  Evaluator evaluadoresSeleccionados){
        for(int i = 0; i < evaluadoresDisponibles.size(); i++) {
            if(evaluadoresDisponibles.get(i).getId().equals(evaluadoresSeleccionados.getId()))
                return true;
        }
        return false;
    }
=======
    private ArticleRepository ArticleDao;
    
    @Autowired
    private EvaluatorService evaluatorService;

>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
    public Article asignarEvaluadores(String articuloId, List<Evaluator> evaluadoresSeleccionados) {
        // Obtener evaluadores disponibles
        List<Evaluator> evaluadoresDisponibles = evaluatorService.FindAvailable();

<<<<<<< HEAD
        boolean todosDisponibles = false;
        // Validar que los evaluadores seleccionados estén disponibles
        for(int i = 0 ; i < evaluadoresSeleccionados.size(); i++) {
            todosDisponibles = validateEvaluator(evaluadoresDisponibles, evaluadoresSeleccionados.get(i)) ;
        }



=======
        // Validar que los evaluadores seleccionados estén disponibles
        boolean todosDisponibles = evaluadoresSeleccionados.stream()
            .allMatch(evaluadoresDisponibles::contains);
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330

        if (!todosDisponibles) {
            throw new IllegalArgumentException("Algunos evaluadores seleccionados no están disponibles.");
        }

        // Validar número de evaluadores
        if (evaluadoresSeleccionados.size() < 2 || evaluadoresSeleccionados.size() > 5) {
            throw new IllegalArgumentException("El número de evaluadores debe estar entre 2 y 5.");
        }

        // Obtener el artículo
<<<<<<< HEAD
        Article articulo = ArticleDao.findById(articuloId);

=======
        Article articulo = ArticleDao.findById(articuloId)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330

        // Asignar evaluadores al artículo
        articulo.setEvaluadores(evaluadoresSeleccionados);

        // Actualizar la lista de artículos de cada evaluador
<<<<<<< HEAD
        for (int i = 0; i < evaluadoresDisponibles.size(); i++) {
            Evaluator evaluador = evaluadoresDisponibles.get(i);
            evaluador.addArticle(articulo);
            evaluatorService.update(evaluador.getId(), evaluador);
        }


=======
        for (Evaluator evaluador : evaluadoresSeleccionados) {
            if (evaluador.getArticles() == null) {
                evaluador.setArticles(new ArrayList<>());
            }
            evaluador.getArticles().add(articulo);
        }

>>>>>>> 53ff72f0d68a5e22859cec4e914681ae5235c330
        // Guardar el artículo
        return ArticleDao.save(articulo);
    }
}

