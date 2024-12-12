
import java.util.ArrayList;
import models.EvaluatorDTO;
import serviceFactory.ServiceFactory;
import services.ServiceEvaluator;
import views.VLogin;

public class Main {

    public static void main(String[] args) {
        try {
            // Obtener la instancia única de ServiceFactory
            ServiceFactory factory = ServiceFactory.getInstance();
            ServiceEvaluator evaluator = factory.getServiceEvaluator();
            EvaluatorDTO evaluator1 = new EvaluatorDTO("12345", "Mario", "mario@gmail.com", new ArrayList<>());
            EvaluatorDTO evaluator2 = new EvaluatorDTO("67890", "Maria", "maria@gmail.com", new ArrayList<>());
            EvaluatorDTO evaluator3 = new EvaluatorDTO("11223", "Juan", "juan@gmail.com", new ArrayList<>());
            EvaluatorDTO evaluator4 = new EvaluatorDTO("44556", "Sara", "sara@gmail.com", new ArrayList<>());
            evaluator.createEvaluator(evaluator1);
            evaluator.createEvaluator(evaluator2);
            evaluator.createEvaluator(evaluator3);
            evaluator.createEvaluator(evaluator4);
            // Abrir la ventana de login con la fábrica de servicios
            VLogin vLogin = new VLogin(factory);
            vLogin.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al inicializar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
