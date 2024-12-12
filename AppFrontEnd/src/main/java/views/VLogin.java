package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import serviceFactory.ServiceFactory;
import services.ServiceConference;
import services.ServiceArticle;
import services.ServiceAuth;

import utilities.Utilities;
import utilities.ViewManager;

public class VLogin extends javax.swing.JFrame {
    private ServiceFactory serviceFactory;
    /**
     * Creates new form VLogin
     */
    public VLogin(ServiceFactory serviceFactory) {
        this.serviceFactory = ServiceFactory.getInstance();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jPanelLeft = new javax.swing.JPanel();
        jPanelMinimize = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jPanelExit = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        jLabelWelcome = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLeft.setBackground(new java.awt.Color(155, 179, 232));

        jPanelMinimize.setBackground(new java.awt.Color(155, 179, 232));

        jLabelMinimize.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.setPreferredSize(new java.awt.Dimension(40, 40));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelMinimizeLayout = new javax.swing.GroupLayout(jPanelMinimize);
        jPanelMinimize.setLayout(jPanelMinimizeLayout);
        jPanelMinimizeLayout.setHorizontalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMinimizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMinimizeLayout.setVerticalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelLogo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelLogo.setForeground(new java.awt.Color(193, 255, 114));
        jLabelLogo.setText("meeting");

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabelLogo)
                .addGap(0, 396, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 500));

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelHeaderMouseDragged(evt);
            }
        });
        jPanelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelHeaderMousePressed(evt);
            }
        });

        jPanelExit.setBackground(new java.awt.Color(255, 255, 255));

        jLabelExit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(0, 0, 0));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.setPreferredSize(new java.awt.Dimension(40, 40));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelExitLayout = new javax.swing.GroupLayout(jPanelExit);
        jPanelExit.setLayout(jPanelExitLayout);
        jPanelExitLayout.setHorizontalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelExitLayout.setVerticalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(760, Short.MAX_VALUE)
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jPanelRight.setBackground(new java.awt.Color(255, 255, 255));

        jLabelWelcome.setBackground(new java.awt.Color(0, 0, 0));
        jLabelWelcome.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabelWelcome.setForeground(new java.awt.Color(0, 0, 0));
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcome.setText("¡Bienvenido de nuevo!");

        jTextFieldEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEmail.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmail.setText("Correo electrónico");
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldEmailMousePressed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(155, 179, 232));
        jButtonLogin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setText("Iniciar sesión");
        jButtonLogin.setBorder(null);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.setText("**********");
        jPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordFieldMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Recordar contraseña");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Montserrat", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¿Todavía no tienes una cuenta? Regístrate");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRightLayout.createSequentialGroup()
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(113, 113, 113)))
                .addContainerGap())
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 460, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMousePressed
        Utilities.headerMousePressed(evt);
    }//GEN-LAST:event_jPanelHeaderMousePressed

    private void jPanelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMouseDragged
        Utilities.headerMouseDragged(evt, this);
    }//GEN-LAST:event_jPanelHeaderMouseDragged

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        Utilities.exitApp();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelExit, jLabelExit, Color.red, Color.white);
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        Utilities.changeColorOnMouseExit(jPanelExit, jLabelExit, Color.white, Color.black);
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        jButtonLogin.setBackground(new Color(169,189,235));
        Utilities.setBoldFont(jButtonLogin);
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        jButtonLogin.setBackground(Utilities.AZUL_FONDO);
        Utilities.setPlainFont(jButtonLogin);
    }//GEN-LAST:event_jButtonLoginMouseExited

    private void jTextFieldEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailMousePressed
        if(jTextFieldEmail.getText().equals("Correo electrónico")){
            jTextFieldEmail.setText("");
            jTextFieldEmail.setForeground(Color.black);
        }
        if(String.valueOf(jPasswordField.getPassword()).isEmpty()){
            jPasswordField.setText("**********");
            jPasswordField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jTextFieldEmailMousePressed

    private void jPasswordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldMousePressed
        if(String.valueOf(jPasswordField.getPassword()).equals("**********")){
            jPasswordField.setText("");
            jPasswordField.setForeground(Color.black);
        }
        
        if(jTextFieldEmail.getText().equals("Correo electrónico")){
            jTextFieldEmail.setText("Correo electrónico");
            jTextFieldEmail.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordFieldMousePressed

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Intento de login con los datos:\n Usuario: " + jTextFieldEmail.getText() + "\nContraseña: " + String.valueOf(jPasswordField.getPassword()), "LOGIN", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        Utilities.minimizeWindow(this);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelMinimize, jLabelMinimize, Color.red, Color.white);
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        Utilities.changeColorOnMouseExit(jPanelMinimize, jLabelMinimize, Utilities.AZUL_FONDO, Color.black);
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String username = jTextFieldEmail.getText();
        String password = new String(jPasswordField.getPassword());

        try {
            // Crear instancia de ServiceAuth
            ServiceAuth authService = new ServiceAuth();

            // Obtener el token del usuario autenticado
            String tokenResponse = authService.login(username, password);

            // Extraer el access_token del JSON
            String accessToken = tokenResponse.substring(tokenResponse.indexOf("access_token\":\"") + 15);
            accessToken = accessToken.substring(0, accessToken.indexOf("\""));

            // Extraer el ID del usuario desde el token decodificado
            String userId = "12345";

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");

            // Obtener otros servicios desde la fábrica
            ServiceConference serviceConference = serviceFactory.getServiceConference();
            ServiceArticle serviceArticle = serviceFactory.getServiceArticle();
            
            try {
                ViewManager viewManager = ViewManager.getInstance();

                // Verifica si la vista de conferencias ya está abierta
                if (!viewManager.isViewOpen("conferences")) {
                    VConferences conferencesView = new VConferences(serviceFactory, userId, () -> {}, accessToken);
                    viewManager.registerView("conferences", conferencesView);
                    conferencesView.setVisible(true);
                } else {
                    // Lleva la ventana al frente si ya está abierta
                    JFrame conferencesView = viewManager.getView("conferences");
                    conferencesView.toFront();
                    conferencesView.repaint();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al abrir la vista de conferencias: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            // Cerrar la ventana de login
            this.dispose();
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(this, "Error en el inicio de sesión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}