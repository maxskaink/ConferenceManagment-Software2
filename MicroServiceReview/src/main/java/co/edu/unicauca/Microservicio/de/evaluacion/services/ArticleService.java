/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;
import ch.qos.logback.classic.boolex.IEvaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.dao.IArticleRepository;
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
    public Article asignarEvaluadores(String articuloId, List<Evaluator> evaluadoresSeleccionados) {
        // Obtener evaluadores disponibles
        List<Evaluator> evaluadoresDisponibles = evaluatorService.FindAvailable();

        boolean todosDisponibles = false;
        // Validar que los evaluadores seleccionados estén disponibles
        for(int i = 0 ; i < evaluadoresSeleccionados.size(); i++) {
            todosDisponibles = validateEvaluator(evaluadoresDisponibles, evaluadoresSeleccionados.get(i)) ;
        }




        if (!todosDisponibles) {
            throw new IllegalArgumentException("Algunos evaluadores seleccionados no están disponibles.");
        }

        // Validar número de evaluadores
        if (evaluadoresSeleccionados.size() < 2 || evaluadoresSeleccionados.size() > 5) {
            throw new IllegalArgumentException("El número de evaluadores debe estar entre 2 y 5.");
        }

        // Obtener el artículo
        Article articulo = ArticleDao.findById(articuloId);


        // Asignar evaluadores al artículo
        articulo.setEvaluadores(evaluadoresSeleccionados);

        // Actualizar la lista de artículos de cada evaluador
        for (int i = 0; i < evaluadoresDisponibles.size(); i++) {
            Evaluator evaluador = evaluadoresDisponibles.get(i);
            evaluador.addArticle(articulo);
            evaluatorService.update(evaluador.getId(), evaluador);
        }


        // Guardar el artículo
        return ArticleDao.save(articulo);
    }
}

