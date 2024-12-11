package utilities;

import java.util.HashMap;
import javax.swing.JFrame;

public class ViewManager {
    private static ViewManager instance;
    private final HashMap<String, JFrame> views;

    private ViewManager() {
        views = new HashMap<>();
    }

    // Singleton pattern para obtener la instancia
    public static ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }

    // Obtener una vista específica
    public JFrame getView(String key) {
        return views.get(key);
    }

    // Registrar una nueva vista
    public void registerView(String key, JFrame view) {
        views.put(key, view);
    }

    // Cerrar y remover una vista del gestor
    public void closeView(String key) {
        JFrame view = views.get(key);
        if (view != null) {
            view.dispose();
            views.remove(key);
        }
    }

    // Verificar si una vista está abierta
    public boolean isViewOpen(String key) {
        return views.containsKey(key);
    }
}
