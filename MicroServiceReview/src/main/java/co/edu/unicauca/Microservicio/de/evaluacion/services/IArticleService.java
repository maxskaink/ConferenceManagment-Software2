/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.services;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import java.util.List;

/**
 *
 * @author ismos
 */
public interface IArticleService {

    /**
     *
     * @param articuloId id of article
     * @param evaluadoresSeleccionados list of Evaluators
     * @return
     */

    public Article asignarEvaluadores(String articuloId, List<Evaluator> evaluadoresSeleccionados); 
}
