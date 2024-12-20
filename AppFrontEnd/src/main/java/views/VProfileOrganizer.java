package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import mapper.Mapper;
import models.Conference;
import models.ConferenceDTO;
import models.ListConferencesDTO;
import models.ListConferencesOrganizerDTO;
import serviceFactory.ServiceFactory;
import serviceObserver.Observer;
import services.ServiceConference;
import utilities.Utilities;
import utilities.ViewManager;

public class VProfileOrganizer extends javax.swing.JFrame implements Observer {

    private final String idOrganizer;
    private final String authToken;
    private ServiceConference serviceConferences;
    private ServiceFactory serviceFactory;
    private Runnable refreshCallback;
    private ListConferencesOrganizerDTO conferencesByOrganizer;

    /**
     * Creates new form JProfileOrganizer
     *
     * @param serviceFactory
     * @param idOrganizer
     * @param token
     */
    public VProfileOrganizer(ServiceFactory serviceFactory, String idOrganizer, String token) throws Exception {
        this.serviceFactory = ServiceFactory.getInstance();
        this.serviceConferences = serviceFactory.getServiceConference();
        this.idOrganizer = idOrganizer;
        this.authToken = token;
        initComponents();
        try {
            this.conferencesByOrganizer = serviceConferences.getConferencesByOrganizer(authToken, this.idOrganizer);
            loadConferences(conferencesByOrganizer);
        } catch (Exception e) {
            System.out.println("No tiene conferencias.");
        }
    }

    public void loadConferences(ListConferencesOrganizerDTO conferenceByOrganizer) {
        if (jTableConferences.isEditing()) {
            jTableConferences.getCellEditor().stopCellEditing();
        }

        List<ConferenceDTO> conferencesDTO = conferenceByOrganizer.getConferences();
        List<Conference> conferences = new ArrayList<Conference>();
        for (ConferenceDTO conference : conferencesDTO) {
            conferences.add(Mapper.DTOToConference(conference));
        }
        if (conferences.isEmpty()) {
            jPanelNoConferences.setVisible(true);
            jScrollPaneConferences.setVisible(false);  // Ocultar el JScrollPane si no hay conferencias
        } else {
            jPanelNoConferences.setVisible(false);
            jScrollPaneConferences.setVisible(true);  // Mostrar el JScrollPane si hay conferencias

            // Crear un modelo de tabla personalizado
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column >= 1;  // Las columnas "Editar", "Borrar" y "Ver más..." son editables
                }
            };
            model.setRowCount(0);

            model.addColumn("Nombre");
            model.addColumn("Editar");  // Nueva columna para editar
            model.addColumn("Borrar");  // Nueva columna para borrar
            model.addColumn("Ver más...");  // Columna para "Ver más"

            System.out.println("Cantidad de conferencias cargadas en la tabla: " + conferences.size());

            for (Conference conf : conferences) {
                model.addRow(new Object[]{conf.getName(), "E", "B", "+"});
            }

            jTableConferences.setModel(model);

            // Asignar renderizadores y editores a las nuevas columnas
            jTableConferences.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
            jTableConferences.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox(), conferences, serviceConferences, this::refreshConferencesById));

            jTableConferences.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
            jTableConferences.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), conferences, serviceConferences, this::refreshConferencesById));

            jTableConferences.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            jTableConferences.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), conferences, serviceConferences, this::refreshConferencesById));

            // Configurar el ancho de las columnas
            jTableConferences.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTableConferences.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTableConferences.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableConferences.getColumnModel().getColumn(3).setPreferredWidth(70);

            jTableConferences.setRowHeight(40);
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
        jPanelNoConferences = new javax.swing.JPanel();
        jLabelNoC1 = new javax.swing.JLabel();
        jLabelNoC2 = new javax.swing.JLabel();
        jLabelNoC3 = new javax.swing.JLabel();
        jLabelNoC4 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabelLupa = new javax.swing.JLabel();
        jPanelConferences = new javax.swing.JPanel();
        jLabelLupa1 = new javax.swing.JLabel();
        jTextFieldSearch1 = new javax.swing.JTextField();
        jScrollPaneConferences = new javax.swing.JScrollPane();
        jTableConferences = new javax.swing.JTable();
        jPanelHeader = new javax.swing.JPanel();
        jPanelExit = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanelMinimize = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelConferencesHeader = new javax.swing.JPanel();
        jLabelConferences = new javax.swing.JLabel();
        jPanelMessages = new javax.swing.JPanel();
        jLabelMessages = new javax.swing.JLabel();
        jComboBoxProfile = new javax.swing.JComboBox<>();
        jLabelConf1 = new javax.swing.JLabel();
        jLabelConf2 = new javax.swing.JLabel();
        jLabelConf3 = new javax.swing.JLabel();
        jButtonRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanelBackground.setBackground(new java.awt.Color(1, 143, 166));
        jPanelBackground.setForeground(new java.awt.Color(204, 204, 204));
        jPanelBackground.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanelBackground.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNoConferences.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNoConferences.setMaximumSize(new java.awt.Dimension(310, 320));
        jPanelNoConferences.setMinimumSize(new java.awt.Dimension(310, 320));
        jPanelNoConferences.setPreferredSize(new java.awt.Dimension(330, 320));
        jPanelNoConferences.setRequestFocusEnabled(false);
        jPanelNoConferences.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNoC1.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabelNoC1.setForeground(new java.awt.Color(233, 233, 233));
        jLabelNoC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoC1.setText("Usted no ha");
        jPanelNoConferences.add(jLabelNoC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 330, -1));

        jLabelNoC2.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabelNoC2.setForeground(new java.awt.Color(233, 233, 233));
        jLabelNoC2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoC2.setText("registrado");
        jLabelNoC2.setMaximumSize(new java.awt.Dimension(227, 44));
        jLabelNoC2.setMinimumSize(new java.awt.Dimension(227, 44));
        jLabelNoC2.setPreferredSize(new java.awt.Dimension(227, 44));
        jPanelNoConferences.add(jLabelNoC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 131, 330, -1));

        jLabelNoC3.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabelNoC3.setForeground(new java.awt.Color(233, 233, 233));
        jLabelNoC3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoC3.setText("ninguna");
        jLabelNoC3.setMaximumSize(new java.awt.Dimension(227, 44));
        jLabelNoC3.setMinimumSize(new java.awt.Dimension(227, 44));
        jLabelNoC3.setPreferredSize(new java.awt.Dimension(227, 44));
        jPanelNoConferences.add(jLabelNoC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 181, 330, -1));

        jLabelNoC4.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabelNoC4.setForeground(new java.awt.Color(233, 233, 233));
        jLabelNoC4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoC4.setText("conferencia");
        jLabelNoC4.setMaximumSize(new java.awt.Dimension(227, 44));
        jLabelNoC4.setMinimumSize(new java.awt.Dimension(227, 44));
        jLabelNoC4.setPreferredSize(new java.awt.Dimension(227, 44));
        jPanelNoConferences.add(jLabelNoC4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 231, 330, -1));

        jTextFieldSearch.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearch.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldSearch.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelNoConferences.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 260, 26));
        jPanelNoConferences.add(jLabelLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jPanelBackground.add(jPanelNoConferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 105, 330, -1));

        jPanelConferences.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConferences.setMaximumSize(new java.awt.Dimension(330, 320));
        jPanelConferences.setMinimumSize(new java.awt.Dimension(330, 320));
        jPanelConferences.setPreferredSize(new java.awt.Dimension(330, 320));
        jPanelConferences.setRequestFocusEnabled(false);
        jPanelConferences.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelConferences.add(jLabelLupa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTextFieldSearch1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearch1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextFieldSearch1.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelConferences.add(jTextFieldSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 260, 26));

        jScrollPaneConferences.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneConferences.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        jTableConferences.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jTableConferences.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneConferences.setViewportView(jTableConferences);

        jPanelConferences.add(jScrollPaneConferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 210));

        jPanelBackground.add(jPanelConferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 105, -1, -1));

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
        jPanelExit.setMaximumSize(new java.awt.Dimension(50, 70));
        jPanelExit.setPreferredSize(new java.awt.Dimension(50, 70));

        jLabelExit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelExit, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        jPanelExitLayout.setVerticalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );

        jPanelHeader.add(jPanelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, 70));

        jPanelMinimize.setBackground(new java.awt.Color(24, 17, 67));

        jLabelMinimize.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.setMaximumSize(new java.awt.Dimension(50, 70));
        jLabelMinimize.setMinimumSize(new java.awt.Dimension(50, 70));
        jLabelMinimize.setPreferredSize(new java.awt.Dimension(50, 70));
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
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMinimizeLayout.setVerticalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelHeader.add(jPanelMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 72));

        jLabelLogo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelLogo.setForeground(new java.awt.Color(193, 255, 114));
        jLabelLogo.setText("meeting");
        jPanelHeader.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 72));

        jPanelConferencesHeader.setBackground(new java.awt.Color(24, 17, 67));

        jLabelConferences.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelConferences.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConferences.setText("Conferencias");
        jLabelConferences.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConferencesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelConferencesHeaderLayout = new javax.swing.GroupLayout(jPanelConferencesHeader);
        jPanelConferencesHeader.setLayout(jPanelConferencesHeaderLayout);
        jPanelConferencesHeaderLayout.setHorizontalGroup(
            jPanelConferencesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConferencesHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelConferences, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelConferencesHeaderLayout.setVerticalGroup(
            jPanelConferencesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelConferences, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelHeader.add(jPanelConferencesHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 72));

        jPanelMessages.setBackground(new java.awt.Color(24, 17, 67));

        jLabelMessages.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabelMessages.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMessages.setText("Mensajes");

        javax.swing.GroupLayout jPanelMessagesLayout = new javax.swing.GroupLayout(jPanelMessages);
        jPanelMessages.setLayout(jPanelMessagesLayout);
        jPanelMessagesLayout.setHorizontalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMessagesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMessagesLayout.setVerticalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMessages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelHeader.add(jPanelMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 0, -1, 72));

        jComboBoxProfile.setBackground(new java.awt.Color(24, 17, 67));
        jComboBoxProfile.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jComboBoxProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "author", "organizer" }));
        jComboBoxProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProfileActionPerformed(evt);
            }
        });
        jPanelHeader.add(jComboBoxProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 15, -1, 40));

        jPanelBackground.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        jLabelConf1.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabelConf1.setForeground(new java.awt.Color(193, 255, 114));
        jLabelConf1.setText("Conferencias ");
        jLabelConf1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelBackground.add(jLabelConf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 105, 373, 53));

        jLabelConf2.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabelConf2.setForeground(new java.awt.Color(193, 255, 114));
        jLabelConf2.setText("en las que eres ");
        jPanelBackground.add(jLabelConf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 164, 405, -1));

        jLabelConf3.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabelConf3.setForeground(new java.awt.Color(193, 255, 114));
        jLabelConf3.setText("organizador");
        jPanelBackground.add(jLabelConf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 229, 390, -1));

        jButtonRegister.setBackground(new java.awt.Color(34, 53, 162));
        jButtonRegister.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister.setText("Registra una conferencia");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        jPanelBackground.add(jButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, 60));

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
        Utilities.changeColorOnMouseExit(jPanelExit, jLabelExit, Utilities.AZUL_OSCURO, Color.white);
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        Utilities.minimizeWindow(this);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        Utilities.changeColorOnMouseEnter(jPanelMinimize, jLabelMinimize, Color.red, Color.white);
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        Utilities.changeColorOnMouseExit(jPanelMinimize, jLabelMinimize, Utilities.AZUL_OSCURO, Color.white);
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void jPanelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMouseDragged
        Utilities.headerMouseDragged(evt, this);
    }//GEN-LAST:event_jPanelHeaderMouseDragged

    private void jPanelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHeaderMousePressed
        Utilities.headerMousePressed(evt);
    }//GEN-LAST:event_jPanelHeaderMousePressed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        VCreateConference createConferenceWindow = new VCreateConference(serviceFactory, authToken, idOrganizer, refreshCallback);
        createConferenceWindow.setVisible(true);
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jLabelConferencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConferencesMouseClicked
        try {
            ViewManager viewManager = ViewManager.getInstance();

            // Verifica si la vista de conferencias ya está abierta
            if (!viewManager.isViewOpen("conferences")) {
                VConferences conferencesView = new VConferences(serviceFactory, idOrganizer, refreshCallback, authToken);
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

    private void jComboBoxProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProfileActionPerformed
        Object selectedItem = jComboBoxProfile.getSelectedItem();
        boolean condicion = "author".equals(selectedItem);
        if (condicion) {
            try {
                ViewManager viewManager = ViewManager.getInstance();

                // Verifica si la vista de perfil ya está abierta
                if (!viewManager.isViewOpen("profile")) {
                    VProfile profileView = new VProfile(serviceFactory, idOrganizer, authToken);
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
        }
    }//GEN-LAST:event_jComboBoxProfileActionPerformed

    public void refreshConferencesById() {
        if (jTableConferences.isEditing()) {
            jTableConferences.getCellEditor().stopCellEditing();
        }

        try {
            ListConferencesOrganizerDTO conferences = serviceConferences.getConferencesByOrganizer(authToken, idOrganizer);

            if (conferences == null || conferences.getConferences().isEmpty()) {
                // Si no hay conferencias, mostrar el mensaje y ocultar la tabla
                jPanelNoConferences.setVisible(true);
                jScrollPaneConferences.setVisible(false);
            } else {
                // Si hay conferencias, actualizamos la tabla
                System.out.println("Conferencias recibidas: " + conferences.getConferences().size());
                loadConferences(conferences);
            }
        } catch (Exception ex) {
            Logger.getLogger(VProfileOrganizer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Error al actualizar las conferencias: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @Override
    public void update(Object arg) {
        SwingUtilities.invokeLater(() -> {
            if (arg == null) {
                System.out.println("El argumento es null.");
            } else {
                System.out.println("Tipo de argumento recibido: " + arg.getClass().getName());
            }

            if (arg instanceof ListConferencesDTO) {
                System.out.println("Entra en el if de organizador");
                ListConferencesOrganizerDTO updatedList;
                try {
                    updatedList = serviceConferences.getConferencesByOrganizer(authToken, idOrganizer);
                    loadConferences(updatedList);
                } catch (Exception ex) {
                    Logger.getLogger(VProfileOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Clase para renderizar un botón en la celda
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private String label;
        private boolean isPushed;
        private List<Conference> conferences;
        private ServiceConference service;  // AÃ±adir el servicio como atributo
        private String action; // Para identificar qué botón fue presionado
        private Runnable refreshCallback;  // El callback para refrescar la lista

        public ButtonEditor(JCheckBox checkBox, List<Conference> conferences, ServiceConference service, Runnable refreshCallback) {
            super(checkBox);
            this.conferences = conferences;
            this.service = service;
            this.refreshCallback = refreshCallback;  // Inicializar el callback
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;

            // Establecer la acción según la columna
            switch (column) {
                case 1:
                    // Columna "Editar"
                    action = "editar";
                    break;
                case 2:
                    // Columna "Borrar"
                    action = "borrar";
                    break;
                case 3:
                    // Columna "Ver más"
                    action = "ver";
                    break;
                default:
                    break;
            }

            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Verifica que haya una fila seleccionada
                int selectedRow = jTableConferences.getSelectedRow();

                if (selectedRow < 0 || selectedRow >= conferences.size()) {
                    JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fila válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return label; // Salir sin procesar
                }

                if (selectedRow >= 0 && selectedRow < conferences.size()) {
                    Conference selectedConference = conferences.get(selectedRow);

                    if ("editar".equals(action)) {
                        VUpdateConference updateWindow = new VUpdateConference(serviceFactory, idOrganizer, selectedConference, authToken, refreshCallback);
                        updateWindow.setVisible(true);
                    } else if ("borrar".equals(action)) {
                        int confirm = JOptionPane.showConfirmDialog(
                                null,
                                "¿Estás seguro de que deseas borrar esta conferencia?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                serviceConferences.deleteConference(authToken, selectedConference.getId());

                                // Usar un pequeño retraso para actualizar la tabla
                                SwingUtilities.invokeLater(() -> refreshConferencesById());

                                JOptionPane.showMessageDialog(null, "Conferencia eliminada de las conferencias disponibles.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                            } catch (Exception ex) {
                                Logger.getLogger(VProfileOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "Error al eliminar la conferencia.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else if ("ver".equals(action)) {
                        String idConference = selectedConference.getId();
                        VConferenceOrganizer infoWindow;
                        try {
                            infoWindow = new VConferenceOrganizer(serviceFactory, idConference, idOrganizer, authToken);
                            infoWindow.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(VProfileOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La conferencia seleccionada ya no está disponible.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JComboBox<String> jComboBoxProfile;
    private javax.swing.JLabel jLabelConf1;
    private javax.swing.JLabel jLabelConf2;
    private javax.swing.JLabel jLabelConf3;
    private javax.swing.JLabel jLabelConferences;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelLupa;
    private javax.swing.JLabel jLabelLupa1;
    private javax.swing.JLabel jLabelMessages;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelNoC1;
    private javax.swing.JLabel jLabelNoC2;
    private javax.swing.JLabel jLabelNoC3;
    private javax.swing.JLabel jLabelNoC4;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelConferences;
    private javax.swing.JPanel jPanelConferencesHeader;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMessages;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JPanel jPanelNoConferences;
    private javax.swing.JScrollPane jScrollPaneConferences;
    private javax.swing.JTable jTableConferences;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSearch1;
    // End of variables declaration//GEN-END:variables
}
