import serviceFactory.ServiceFactory;
import views.VLogin;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener la instancia única de ServiceFactory
            ServiceFactory factory = ServiceFactory.getInstance();

            // Abrir la ventana de login con la fábrica de servicios
            VLogin vLogin = new VLogin(factory);
            vLogin.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al inicializar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
                                                                                                