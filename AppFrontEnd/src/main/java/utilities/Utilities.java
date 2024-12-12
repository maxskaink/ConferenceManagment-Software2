package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.BasicDate;

public class Utilities {
    private static int xMouse;
    private static int yMouse;
    
    public static final Color AZUL_FONDO = new Color(155, 179, 232);
    public static final Color AZUL_ACENTOS = new Color(1, 143, 166);
    public static final Color VERDE = new Color(193, 255, 114);
    public static final Color MORADO = new Color(94, 23, 235);
    public static final Color AZUL_OSCURO = new Color(24, 17,67);
    
    public static void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    public static void headerMouseDragged(MouseEvent evt, JFrame frame) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        frame.setLocation(x - xMouse, y - yMouse);
    }
    
    public static void exitApp() {
        System.exit(0);
    }
    
    public static void minimizeWindow(JFrame frame) {
        frame.setExtendedState(JFrame.ICONIFIED);
    }
    
    public static void changeColorOnMouseEnter(JPanel panel, JLabel label, Color panelColor, Color labelColor) {
        panel.setBackground(panelColor);
        label.setForeground(labelColor);
    }

    public static void changeColorOnMouseExit(JPanel panel, JLabel label, Color panelColor, Color labelColor) {
        panel.setBackground(panelColor);
        label.setForeground(labelColor);
    }
    
    public static void setBoldFont(JComponent component) {
        Font boldFont = component.getFont().deriveFont(Font.BOLD);
        component.setFont(boldFont);
    }

    public static void setPlainFont(JComponent component) {
        Font plainFont = component.getFont().deriveFont(Font.PLAIN);
        component.setFont(plainFont);
    }
    
    public static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Esto asegura que solo se acepten fechas estrictamente válidas.

        try {
            // Intenta analizar la fecha
            sdf.parse(date);
            return true;  // Si no lanza excepción, es válida.
        } catch (ParseException e) {
            return false;  // Si lanza excepción, la fecha no es válida.
        }
    }
    
    public static void resetFieldOnPress(JTextField textField, String defaultText, Color defaultColor, Color newColor) {
        if (textField.getText().equals(defaultText)) {
            textField.setText("");
            textField.setForeground(newColor);
        }
    }
    
    public static void resetFieldFocusLost(JTextField textField, String defaultText, Color defaultColor, Color newColor) {
        if(textField.getText().isEmpty()){
            textField.setText(defaultText);
            textField.setForeground(defaultColor);
        }
    }

    public static BasicDate parseBasicDate(Object input) {
        if (input instanceof String) {
            // Manejo de cadenas de texto
            String dateString = (String) input;
            try {
                // Dividir la cadena por el delimitador "-"
                String[] parts = dateString.split("-");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Formato de fecha inválido. Use 'dd-MM-yyyy'.");
                }

                // Extraer día, mes y año
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                // Validar valores (opcional)
                if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
                    throw new IllegalArgumentException("Valores de fecha fuera de rango.");
                }

                // Crear y retornar el objeto BasicDate
                return new BasicDate(day, month, year);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de fecha inválido. Use 'dd-MM-yyyy'.");
            }
        } else if (input instanceof Date) {
            // Manejo de objetos Date
            Date date = (Date) input;

            // Usar Calendar para extraer día, mes y año
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(date);

            int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
            int month = calendar.get(java.util.Calendar.MONTH) + 1; // Los meses empiezan desde 0
            int year = calendar.get(java.util.Calendar.YEAR);

            // Crear y retornar el objeto BasicDate
            return new BasicDate(day, month, year);
        } else {
            throw new IllegalArgumentException("Tipo de entrada no soportado. Use String ('dd-MM-yyyy') o Date.");
        }
    }
    
    public static Date toDate(BasicDate d) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(d.getYear(), d.getMonth() - 1, d.getDay());
        return calendar.getTime();
    }

}
