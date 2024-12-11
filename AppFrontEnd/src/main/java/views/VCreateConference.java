/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import services.ServiceConference;
import java.awt.Color;
import javax.swing.JOptionPane;
import models.BasicDate;
import models.ConferenceDTO;
import utilities.Utilities;

/**
 *
 * @author Isabela Sánchez Saavedra <isanchez@unicauca.edu.co>
 */
public class VCreateConference extends javax.swing.JFrame {
    private String authToken; // Token de autenticación obtenido al inicio
    private ServiceConference serviceConference;
    private VProfileOrganizer profileOrganizer;
    private String idOrganizer;
    private Runnable refreshCallback;

    /**
     * Creates new form VProfileOrganizer
     */
    public VCreateConference(ServiceConference serviceConferences, String authToken, String idOrganizer, Runnable refreshCallback) {
        initComponents();
        this.serviceConference = serviceConferences;
        this.authToken = authToken;
        this.idOrganizer = idOrganizer;
        this.refreshCallback = refreshCallback;
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
        jPanelHeader = new javax.swing.JPanel();
        jPanelExit = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanelMinimize = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelProfile = new javax.swing.JLabel();
        jLabelConferences = new javax.swing.JLabel();
        jLabelMessages = new javax.swing.JLabel();
        jButtonRegister = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldPlace = new javax.swing.JTextField();
        jLabelPlace = new javax.swing.JLabel();
        jTextFieldStartDate = new javax.swing.JTextField();
        jLabelStartDate = new javax.swing.JLabel();
        jTextFieldTheme = new javax.swing.JTextField();
        jLabelTheme = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabelDescription = new javax.swing.JLabel();
        jTextFieldFinishDate = new javax.swing.JTextField();
        jLabelFinishDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanelBackground.setBackground(new java.awt.Color(1, 143, 166));
        jPanelBackground.setForeground(new java.awt.Color(204, 204, 204));
        jPanelBackground.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanelBackground.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanelBackground.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeader.setBackground(new java.awt.Color(24, 17, 67));
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
        jPanelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelExit.setBackground(new java.awt.Color(24, 17, 67));

        jLabelExit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(jPanelExitLayout.createSequentialGroup()
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelHeader.add(jPanelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 0, -1, -1));

        jPanelMinimize.setBackground(new java.awt.Color(24, 17, 67));

        jLabelMinimize.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelHeader.add(jPanelMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelLogo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelLogo.setForeground(new java.awt.Color(193, 255, 114));
        jLabelLogo.setText("meeting");
        jPanelHeader.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 60));

        jLabelProfile.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelProfile.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfile.setText("Mi perfil");
        jLabelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelProfile.setMaximumSize(new java.awt.Dimension(60, 18));
        jLabelProfile.setMinimumSize(new java.awt.Dimension(60, 18));
        jLabelProfile.setName(""); // NOI18N
        jLabelProfile.setPreferredSize(new java.awt.Dimension(60, 18));
        jPanelHeader.add(jLabelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 60));

        jLabelConferences.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelConferences.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConferences.setText("Conferencias");
        jLabelConferences.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConferencesMouseClicked(evt);
            }
        });
        jPanelHeader.add(jLabelConferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 60));

        jLabelMessages.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelMessages.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMessages.setText("Mensajes");
        jLabelMessages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelHeader.add(jLabelMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        jPanelBackground.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jButtonRegister.setBackground(new java.awt.Color(34, 53, 162));
        jButtonRegister.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButtonRegister.setText("REGISTRAR");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        jPanelBackground.add(jButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 170, 60));

        jLabelTitle.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Crea una nueva conferencia");
        jPanelBackground.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, -1));

        jLabelName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName.setText("NOMBRE");
        jPanelBackground.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jTextFieldName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldName.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldName.setText("Nombre de la conferencia");
        jTextFieldName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldName.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldName.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldName.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNameFocusLost(evt);
            }
        });
        jTextFieldName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldNameMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 270, -1));

        jTextFieldPlace.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPlace.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldPlace.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldPlace.setText("Lugar de la conferencia");
        jTextFieldPlace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldPlace.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldPlace.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldPlace.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldPlace.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPlaceFocusLost(evt);
            }
        });
        jTextFieldPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldPlaceMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jLabelPlace.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelPlace.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPlace.setText("LUGAR");
        jPanelBackground.add(jLabelPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jTextFieldStartDate.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldStartDate.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldStartDate.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldStartDate.setText("00/00/0000");
        jTextFieldStartDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldStartDate.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldStartDate.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldStartDate.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldStartDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldStartDateFocusLost(evt);
            }
        });
        jTextFieldStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldStartDateMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabelStartDate.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelStartDate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStartDate.setText("FECHA DE INICIO");
        jPanelBackground.add(jLabelStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jTextFieldTheme.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTheme.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldTheme.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldTheme.setText("Temas a tratar en la conferencia");
        jTextFieldTheme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldTheme.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldTheme.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldTheme.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldTheme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldThemeFocusLost(evt);
            }
        });
        jTextFieldTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldThemeMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        jLabelTheme.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelTheme.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTheme.setText("TEMAS");
        jPanelBackground.add(jLabelTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        jTextFieldDescription.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDescription.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldDescription.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldDescription.setText("Descripción de la conferencia");
        jTextFieldDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldDescription.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldDescription.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldDescription.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDescriptionFocusLost(evt);
            }
        });
        jTextFieldDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldDescriptionMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabelDescription.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelDescription.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDescription.setText("DESCRIPCIÓN");
        jPanelBackground.add(jLabelDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jTextFieldFinishDate.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldFinishDate.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldFinishDate.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldFinishDate.setText("00/00/0000");
        jTextFieldFinishDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldFinishDate.setMaximumSize(new java.awt.Dimension(270, 30));
        jTextFieldFinishDate.setMinimumSize(new java.awt.Dimension(270, 30));
        jTextFieldFinishDate.setPreferredSize(new java.awt.Dimension(270, 30));
        jTextFieldFinishDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFinishDateFocusLost(evt);
            }
        });
        jTextFieldFinishDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldFinishDateMousePressed(evt);
            }
        });
        jPanelBackground.add(jTextFieldFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        jLabelFinishDate.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelFinishDate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFinishDate.setText("FECHA DE FIN");
        jPanelBackground.add(jLabelFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelExit, jLabelExit, Color.red, Color.white);
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        Utilities.changeColorOnMouseExit(jPanelExit, jLabelExit, Utilities.AZUL_OSCURO, Color.black);
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        Utilities.minimizeWindow(this);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelMinimize, jLabelMinimize, Color.red, Color.white);
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        Utilities.changeColorOnMouseExit(jPanelMinimize, jLabelMinimize, Utilities.AZUL_OSCURO, Color.black);
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void jPanelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMouseDragged
        Utilities.headerMouseDragged(evt, this);
    }//GEN-LAST:event_jPanelHeaderMouseDragged

    private void jPanelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMousePressed
        Utilities.headerMousePressed(evt);
    }//GEN-LAST:event_jPanelHeaderMousePressed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jTextFieldNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNameMousePressed
        Utilities.resetFieldOnPress(jTextFieldName, "Nombre de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldNameMousePressed

    private void jTextFieldNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNameFocusLost
        Utilities.resetFieldFocusLost(jTextFieldName, "Nombre de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldNameFocusLost

    private void jTextFieldPlaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPlaceMousePressed
        Utilities.resetFieldOnPress(jTextFieldPlace, "Lugar de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldPlaceMousePressed

    private void jTextFieldPlaceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPlaceFocusLost
        Utilities.resetFieldFocusLost(jTextFieldPlace, "Lugar de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldPlaceFocusLost

    private void jTextFieldStartDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldStartDateMousePressed
        Utilities.resetFieldOnPress(jTextFieldStartDate, "00/00/0000", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldStartDateMousePressed

    private void jTextFieldStartDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartDateFocusLost
        Utilities.resetFieldFocusLost(jTextFieldStartDate, "00/00/0000", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldStartDateFocusLost

    private void jTextFieldFinishDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFinishDateMousePressed
        Utilities.resetFieldOnPress(jTextFieldFinishDate, "00/00/0000", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldFinishDateMousePressed

    private void jTextFieldFinishDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFinishDateFocusLost
        Utilities.resetFieldFocusLost(jTextFieldFinishDate, "00/00/0000", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldFinishDateFocusLost

    private void jTextFieldDescriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDescriptionMousePressed
        Utilities.resetFieldOnPress(jTextFieldDescription, "Descripción de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldDescriptionMousePressed

    private void jTextFieldDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescriptionFocusLost
        Utilities.resetFieldFocusLost(jTextFieldDescription, "Descripción de la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldDescriptionFocusLost

    private void jTextFieldThemeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldThemeMousePressed
        Utilities.resetFieldOnPress(jTextFieldTheme, "Temas a tratar en la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldThemeMousePressed

    private void jTextFieldThemeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldThemeFocusLost
        Utilities.resetFieldFocusLost(jTextFieldTheme, "Temas a tratar en la conferencia", Color.gray, Color.black);
    }//GEN-LAST:event_jTextFieldThemeFocusLost

    private void jLabelConferencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConferencesMouseClicked
        if (profileOrganizer == null || !profileOrganizer.isDisplayable()) {
            //profileOrganizer = new VProfileOrganizer(serviceConferences, idOrganizer, serviceUser);

            profileOrganizer.setVisible(true);
        } else {
            profileOrganizer.toFront();
            profileOrganizer.repaint();
        }
    }//GEN-LAST:event_jLabelConferencesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabelConferences;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelFinishDate;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMessages;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPlace;
    private javax.swing.JLabel jLabelProfile;
    private javax.swing.JLabel jLabelStartDate;
    private javax.swing.JLabel jLabelTheme;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldFinishDate;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPlace;
    private javax.swing.JTextField jTextFieldStartDate;
    private javax.swing.JTextField jTextFieldTheme;
    // End of variables declaration//GEN-END:variables
}
