/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.dao;
import org.springframework.stereotype.Repository;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ismos
 */
@Repository 
public interface EvaluatorRepository extends JpaRepository<Evaluator, String> {}
