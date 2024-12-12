package co.edu.unicauca.Microservicio.de.evaluacion.dao;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;

import java.util.List;

public interface IEvaluatorsRepository {
    /**
     * @Param id IDEvaluatro
     * @return Evaluator
     */
    Evaluator getEvaluator(String id);

    /**
     *
     * @return list of Evaluators
     */
    List<Evaluator> getAllEvaluators();

    /**
     *
     * @param evaluator  evaluator to save
     * @return evaluator save
     */
    Evaluator saveEvaluator(Evaluator evaluator);

    /**
     *
     * @param id evaluator to delete
     * @return evaluator delete
     */
    Evaluator deleteEvaluator(String id);

    /**
     *
     * @param id id of evaluator to consult
     * @return boolean true = exist,  false = no exist
     */
    Boolean Exist(String id);

    /**
     *
     * @param id evaluator to updte
     * @return update evaluators
     */
    Evaluator UpdateEvaluator(String id, Evaluator UpdateEvaluator);

}
