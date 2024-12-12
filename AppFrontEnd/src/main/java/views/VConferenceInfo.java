package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mapper.Mapper;

import services.ServiceConference;
import utilities.Utilities;
import models.Conference;
import serviceFactory.ServiceFactory;
import services.ServiceArticle;
import utilities.ViewManager;

public class VConferenceInfo extends javax.swing.JFrame {
    private final ServiceFactory serviceFactory;
    private final String idAuthor;
    private final Conference conference;
    private final ServiceConference serviceConferences;
    private final ServiceArticle serviceArticle;
    private final String authToken;
    
    public VConferenceInfo(ServiceFactory serviceFactory, String idConference, String idAuthor, String token) throws Exception {       
        this.serviceFactory = ServiceFactory.getInstance();
        this.serviceConferences = serviceFactory.getServiceConference();
        this.serviceArticle = serviceFactory.getServiceArticle();
        this.idAuthor = idAuthor;
        this.authToken = token;
        this.conference = Mapper.DTOToConference(serviceConferences.getConferenceById(token, idConference));
        initComponents();
        mostrarDatos(conference);
        mostrarBoton(conference);
    }


    public void mostrarDatos(Conference conference){
       jLabelShownName.setText(conference.getName());
       jLabelShownDateStart.setText("Desde: "+conference.getStartDate());
       jLabelShownDateEnds.setText("Hasta: " + conference.getFinishDate());
       jLabelShownPlace.setText(conference.getPlace());
       jLabelShownDescription.setText(conference.getDescription());
       jLabelShownTopic.setText(conference.getTopic());
    }
    public void mostrarBoton(Conference conference){
     if(conference.isState()){
        jButtonNoOpen.setVisible(false);
        jButtonIsOpen.setVisible(true);
     }
     else {
       jButtonNoOpen.setVisible(true);
       jButtonIsOpen.setVisible(false);
     }
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
        jPanelViewInfo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelShownName = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelShownDateEnds = new javax.swing.JLabel();
        jLabelPlace = new javax.swing.JLabel();
        jLabelShownPlace = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jLabelShownDescription = new javax.swing.JLabel();
        jLabelShownTopic = new javax.swing.JLabel();
        jLabelTopic = new javax.swing.JLabel();
        jLabelShownDateStart = new javax.swing.JLabel();
        jButtonNoOpen = new javax.swing.JButton();
        jButtonIsOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanelBackground.setBackground(new java.awt.Color(155, 179, 232));

        jPanelHeader.setBackground(new java.awt.Color(1, 143, 166));
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

        jPanelExit.setBackground(new java.awt.Color(1, 143, 166));

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
            .addGroup(jPanelExitLayout.createSequentialGroup()
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMinimize.setBackground(new java.awt.Color(1, 143, 166));

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
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelLogo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelLogo.setForeground(new java.awt.Color(193, 255, 114));
        jLabelLogo.setText("meeting");

        jLabelProfile.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelProfile.setText("Mi perfil");
        jLabelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProfileMouseClicked(evt);
            }
        });

        jLabelConferences.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelConferences.setText("Conferencias");
        jLabelConferences.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConferencesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabelProfile)
                .addGap(65, 65, 65)
                .addComponent(jLabelConferences)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(55, 55, 55)
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelConferences, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelViewInfo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelViewInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(94, 23, 235));

        jLabelName.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Conferencia:");

        jLabelShownName.setFont(new java.awt.Font("Montserrat", 1, 22)); // NOI18N
        jLabelShownName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelShownName.setText("jdjd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelShownName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShownName))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelName.getAccessibleContext().setAccessibleParent(jPanelViewInfo);
        jLabelShownName.getAccessibleContext().setAccessibleName("NombreConferencia");

        jPanelViewInfo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 680, 60));

        jLabelDate.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(1, 143, 166));
        jLabelDate.setText("Fecha:");
        jPanelViewInfo.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabelShownDateEnds.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelShownDateEnds.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownDateEnds.setText("ff");
        jPanelViewInfo.add(jLabelShownDateEnds, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 215, -1));

        jLabelPlace.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelPlace.setForeground(new java.awt.Color(1, 143, 166));
        jLabelPlace.setText("Lugar:");
        jPanelViewInfo.add(jLabelPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabelShownPlace.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelShownPlace.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownPlace.setText("f");
        jPanelViewInfo.add(jLabelShownPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 230, -1));

        jLabelDescription.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelDescription.setForeground(new java.awt.Color(1, 143, 166));
        jLabelDescription.setText("Descripción:");
        jPanelViewInfo.add(jLabelDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabelShownDescription.setFont(new java.awt.Font("Montserrat", 1, 17)); // NOI18N
        jLabelShownDescription.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelShownDescription.setLabelFor(jLabelDescription);
        jLabelShownDescription.setText("gg");
        jLabelShownDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelViewInfo.add(jLabelShownDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 190, 211));

        jLabelShownTopic.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelShownTopic.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownTopic.setText("f");
        jPanelViewInfo.add(jLabelShownTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 215, -1));

        jLabelTopic.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelTopic.setForeground(new java.awt.Color(1, 143, 166));
        jLabelTopic.setText("Temas:");
        jPanelViewInfo.add(jLabelTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabelShownDateStart.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelShownDateStart.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownDateStart.setText("ff");
        jPanelViewInfo.add(jLabelShownDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 215, -1));

        jButtonNoOpen.setBackground(new java.awt.Color(193, 255, 114));
        jButtonNoOpen.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jButtonNoOpen.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNoOpen.setText("No acepta articulos");
        jButtonNoOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoOpenActionPerformed(evt);
            }
        });
        jPanelViewInfo.add(jButtonNoOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 280, 70));

        jButtonIsOpen.setBackground(new java.awt.Color(193, 255, 114));
        jButtonIsOpen.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jButtonIsOpen.setForeground(new java.awt.Color(0, 0, 0));
        jButtonIsOpen.setText("Enviar articulo");
        jButtonIsOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIsOpenActionPerformed(evt);
            }
        });
        jPanelViewInfo.add(jButtonIsOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 280, 70));

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanelViewInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanelViewInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelViewInfo.getAccessibleContext().setAccessibleName("jPanelViewInfC");

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
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelExit, jLabelExit, Color.red, Color.white);
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        Utilities.changeColorOnMouseExit(jPanelExit, jLabelExit, Utilities.AZUL_ACENTOS, Color.black);
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        Utilities.changeColorOnMouseExit(jPanelMinimize, jLabelMinimize, Utilities.AZUL_ACENTOS, Color.black);
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelMinimize, jLabelMinimize, Color.red, Color.white);
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        Utilities.minimizeWindow(this);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jButtonIsOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIsOpenActionPerformed
        VPapers createPaperWindow = new VPapers(serviceFactory, conference, idAuthor, authToken);
        createPaperWindow.setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_jButtonIsOpenActionPerformed

    private void jLabelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProfileMouseClicked
        try {
            ViewManager viewManager = ViewManager.getInstance();

            // Verifica si la vista de perfil ya está abierta
            if (!viewManager.isViewOpen("profile")) {
                VProfile profileView = new VProfile(serviceFactory, idAuthor, authToken);
                viewManager.registerView("profile", profileView);
                profileView.setVisible(true);
            } else {
                // Lleva la ventana al frente si ya está abierta
                JFrame profileView = viewManager.getView("profile");
                profileView.toFront();
                profileView.repaint();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir la vista de perfil: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabelProfileMouseClicked

    private void jLabelConferencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConferencesMouseClicked
        try {
            ViewManager viewManager = ViewManager.getInstance();

            // Verifica si la vista de conferencias ya está abierta
            if (!viewManager.isViewOpen("conferences")) {
                VConferences conferencesView = new VConferences(serviceFactory, idAuthor, () -> {}, authToken);
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
    }//GEN-LAST:event_jLabelConferencesMouseClicked

    private void jButtonNoOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNoOpenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIsOpen;
    private javax.swing.JButton jButtonNoOpen;
    private javax.swing.JLabel jLabelConferences;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPlace;
    private javax.swing.JLabel jLabelProfile;
    private javax.swing.JLabel jLabelShownDateEnds;
    private javax.swing.JLabel jLabelShownDateStart;
    private javax.swing.JLabel jLabelShownDescription;
    private javax.swing.JLabel jLabelShownName;
    private javax.swing.JLabel jLabelShownPlace;
    private javax.swing.JLabel jLabelShownTopic;
    private javax.swing.JLabel jLabelTopic;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JPanel jPanelViewInfo;
    // End of variables declaration//GEN-END:variables
}
