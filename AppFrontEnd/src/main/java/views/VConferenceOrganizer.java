
package views;

import models.Article;
import models.ListArticleConferencesDTO;
import models.Conference;
import services.*;
import utilities.Utilities;

import java.awt.Color;
import java.util.List;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import mapper.Mapper;
import models.EvaluatorDTO;
import serviceFactory.ServiceFactory;


public class VConferenceOrganizer extends javax.swing.JFrame {
     private ServiceFactory serviceFactory;
     private ServiceConference serviceConference;
     private ServiceArticle serviceArticle;
     private String idConference;
     private String idAuthor;
     private String authToken;
     private Conference conference;
    /**
     * Creates new form VLogin
     */
    public VConferenceOrganizer(ServiceFactory serviceFactory, String idConference, String idAuthor, String token) throws Exception {
        initComponents();
        this.serviceFactory = ServiceFactory.getInstance();
        this.serviceArticle = serviceFactory.getServiceArticle();
        this.serviceConference = serviceFactory.getServiceConference();
        this.idConference = idConference;
        this.idAuthor = idAuthor;
        this.authToken = token;
        this.conference = Mapper.DTOToConference(serviceConference.getConferenceById(authToken, idConference));
        jLabelShownName.setText(conference.getName());
        ListArticleConferencesDTO articles = serviceArticle.getArticlesByConference(authToken, idConference);
        listPapers(articles);
    }

    public void listPapers(ListArticleConferencesDTO ArticlesDTO) {
        List<Article> Articles = ArticlesDTO.getArticles();
        if (Articles.isEmpty()) {
            System.out.println("No hay articulos");
            jTableNoArticles.setVisible(false);
        } else {
            jTableNoArticles.setVisible(true);

            DefaultTableModel MyTable = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column >= 1;  // Las columnas "Editar", "Borrar" y "Ver más..." son editables
                }
            };
            MyTable.addColumn("Autores");
            MyTable.addColumn("Nombre del articulo");
            MyTable.addColumn("Informacion");
            MyTable.addColumn("Asignacion");

            for (Article art : Articles) {
                try {
                    // Obtener evaluadores asignados al artículo
                    ServiceEvaluator s = serviceFactory.getServiceEvaluator();
                    List<EvaluatorDTO> evaluators = s.getEvaluatorsByArticle(authToken, art.getId());
                    art.setEvaluators(evaluators); // Establecer evaluadores al artículo

                    // Determinar el texto del botón en base a los evaluadores asignados
                    String assignButtonLabel = evaluators != null && !evaluators.isEmpty() ? "Asignado" : "Asignar";
                    MyTable.addRow(new Object[]{idAuthor, art.getName(), "INF", assignButtonLabel});

                } catch (Exception e) {
                    Logger.getLogger(VConferenceOrganizer.class.getName()).log(Level.WARNING, "Error al obtener evaluadores para el artículo: " + art.getName(), e);
                    MyTable.addRow(new Object[]{idAuthor, art.getName(), "INF", "Asignar"}); // Por defecto
                }
            }

            jTableNoArticles.setModel(MyTable);

            // Asignar renderizadores y editores a las columnas "Informacion" y "Asignacion"
            jTableNoArticles.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
            jTableNoArticles.getColumnModel().getColumn(2).setCellEditor(new ButtonEditorArticles(
                    new JCheckBox(),
                    Articles,
                    serviceArticle,
                    this::refreshArticlesById));

            jTableNoArticles.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            jTableNoArticles.getColumnModel().getColumn(3).setCellEditor(new AssignEvaluatorButtonEditor(
                    new JCheckBox(),
                    Articles,
                    serviceArticle,
                    this::refreshArticlesById));

            // Configurar el ancho de las columnas
            jTableNoArticles.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTableNoArticles.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableNoArticles.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableNoArticles.getColumnModel().getColumn(3).setPreferredWidth(70);

            jTableNoArticles.setRowHeight(40);
        }
    }



class AssignEvaluatorButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean isPushed;
    private List<Article> articles;
    private ServiceArticle serviceArticle;
    private Runnable refreshCallback;

    public AssignEvaluatorButtonEditor(JCheckBox checkBox, List<Article> articles, ServiceArticle serviceArticle, Runnable refreshCallback) {
        super(checkBox);
        this.articles = articles;
        this.serviceArticle = serviceArticle;
        this.refreshCallback = refreshCallback;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            // Validar el índice seleccionado
            int selectedRow = jTableNoArticles.getSelectedRow();
            if (selectedRow < 0 || selectedRow >= articles.size()) {
                JOptionPane.showMessageDialog(null, "Seleccione un artículo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                isPushed = false;
                return label;
            }

            Article selectedArticle = articles.get(selectedRow);

            if ("Asignar".equals(label)) {
                // Abrir VEvaluators
                try {
                    VEvaluators evaluatorsWindow = new VEvaluators(serviceFactory, selectedArticle.getId(), idAuthor, () -> {
                        // Actualizar el estado del botón en el callback
                        label = "Asignado";
                        refreshCallback.run();
                    }, authToken);

                    evaluatorsWindow.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VConferenceOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al abrir la ventana de evaluadores.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los evaluadores ya fueron asignados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArticles = new javax.swing.JTable();
        jPanelBackground = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jPanelExit = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanelMinimize = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelShownName = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableNoArticles = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jTableArticles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Autores", "Nombre del articulo", "Calificación"
            }
        ));
        jScrollPane1.setViewportView(jTableArticles);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanelBackground.setBackground(new java.awt.Color(155, 179, 232));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(55, 55, 55)
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONFERENCIA");

        jLabelShownName.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabelShownName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelShownName.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabelShownName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShownName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelBackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, 70));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Ingrese el nombre del articulo que desea buscar");
        jPanelBackground.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 510, 30));

        jButton1.setBackground(new java.awt.Color(94, 23, 235));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton1.setText("Info del Paper");
        jPanelBackground.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 170, 30));

        jTableNoArticles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Autores", "Nombre del articulo", "Calificación"
            }
        ));
        jScrollPane2.setViewportView(jTableNoArticles);

        jPanelBackground.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 700, 270));

        jButton4.setBackground(new java.awt.Color(94, 23, 235));
        jButton4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton4.setText("Buscar");
        jPanelBackground.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 90, 30));

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
    
    public void refreshArticlesById() {
    ListArticleConferencesDTO articles;
    try {
        articles = serviceArticle.getArticlesByConference(authToken, idConference);
        listPapers(articles);
    } catch (Exception ex) {
        Logger.getLogger(VConferenceOrganizer.class.getName()).log(Level.SEVERE, null, ex);
    }
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

    class ButtonEditorArticles extends DefaultCellEditor {

    private JButton button;
    private String label;
    private boolean isPushed;
    private List<Article> articles;
    private ServiceArticle service;  // AÃ±adir el servicio como atributo
    private String action; // Para identificar qué botón fue presionado
    private Runnable refreshCallback;  // El callback para refrescar la lista

    public ButtonEditorArticles(JCheckBox checkBox, List<Article> articles, ServiceArticle service, Runnable refreshCallback) {
        super(checkBox);
        this.articles = articles;
        this.service = service;
        this.refreshCallback = refreshCallback;  // Inicializar el callback
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;

        // Establecer la acción según la columna
        if (column == 2) { // Columna "Editar"
            action = "info";
        } else if (column == 3) { // Columna "Borrar"
            action = "asignar";
        }

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            // Obtener la conferencia seleccionada
            Article selectedArticle = articles.get(jTableArticles.getSelectedRow());

            if (action.equals("info")) {
                // Lógica para la columna "Editar"
            } else if (action.equals("borrar")) {
                if (refreshCallback != null) {
                    refreshCallback.run();
                }
            } else if (action.equals("ver")) {
                // Lógica para la columna "Ver más"
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelShownName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableArticles;
    private javax.swing.JTable jTableNoArticles;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
