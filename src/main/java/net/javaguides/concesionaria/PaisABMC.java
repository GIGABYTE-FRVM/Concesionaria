/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package net.javaguides.concesionaria;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import net.javaguides.hibernate.model.Pais;
import net.javaguides.hibernate.model.Region;

/**
 *
 * @author matya
 */
public class PaisABMC extends javax.swing.JFrame {

    GestorPaisABMC gestor;
    int xMouse, yMouse;
    Color colorBackgroundButton = new Color(255, 153, 51);
    Color colorBorderButton = new Color(204, 204, 204);

    public PaisABMC(GestorPaisABMC gestorPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(2);
        DefaultTableModel modelo = new DefaultTableModel();
        conocergestor(gestorPadre);
        tablaDatos.setModel(gestor.mostrarDatos());
        setIdUltimoPais();
        
        actualizarComboRegiones();
    }

    public void conocergestor(GestorPaisABMC gestor) {
        this.gestor = gestor;
    }

    /**
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panelDatosRegistrados = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        separadorId = new javax.swing.JSeparator();
        separadorNombre = new javax.swing.JSeparator();
        lblNombre = new javax.swing.JLabel();
        panelBtnRegistrar = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        panelBtnActualizar = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        panelBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        panelBtnCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        cboRegion = new javax.swing.JComboBox<>();
        btnRegion = new javax.swing.JLabel();
        panelTablaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barraSuperiorVentana = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JPanel();
        lblBtnCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatosRegistrados.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(153, 153, 153));
        txtId.setBorder(null);
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese el nombre del país");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("INFORMACIÓN DEL PAIS");

        lblId.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        lblId.setText("ID");

        separadorId.setEnabled(false);

        separadorNombre.setEnabled(false);

        lblNombre.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        lblNombre.setText("NOMBRE");

        panelBtnRegistrar.setBackground(new java.awt.Color(255, 153, 51));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBtnRegistrarLayout = new javax.swing.GroupLayout(panelBtnRegistrar);
        panelBtnRegistrar.setLayout(panelBtnRegistrarLayout);
        panelBtnRegistrarLayout.setHorizontalGroup(
            panelBtnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelBtnRegistrarLayout.setVerticalGroup(
            panelBtnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        panelBtnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 153, 51));
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizar.setText("Modificar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBtnActualizarLayout = new javax.swing.GroupLayout(panelBtnActualizar);
        panelBtnActualizar.setLayout(panelBtnActualizarLayout);
        panelBtnActualizarLayout.setHorizontalGroup(
            panelBtnActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelBtnActualizarLayout.setVerticalGroup(
            panelBtnActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        panelBtnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 153, 51));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBtnEliminarLayout = new javax.swing.GroupLayout(panelBtnEliminar);
        panelBtnEliminar.setLayout(panelBtnEliminarLayout);
        panelBtnEliminarLayout.setHorizontalGroup(
            panelBtnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelBtnEliminarLayout.setVerticalGroup(
            panelBtnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        panelBtnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 153, 51));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBtnCancelarLayout = new javax.swing.GroupLayout(panelBtnCancelar);
        panelBtnCancelar.setLayout(panelBtnCancelarLayout);
        panelBtnCancelarLayout.setHorizontalGroup(
            panelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelBtnCancelarLayout.setVerticalGroup(
            panelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        lblPais.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        lblPais.setText("REGION");

        cboRegion.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        cboRegion.setForeground(new java.awt.Color(51, 51, 51));
        cboRegion.setBorder(null);
        cboRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRegionActionPerformed(evt);
            }
        });

        btnRegion.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnRegion.setForeground(new java.awt.Color(255, 153, 51));
        btnRegion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegion.setText("ABMC Region");
        btnRegion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDatosRegistradosLayout = new javax.swing.GroupLayout(panelDatosRegistrados);
        panelDatosRegistrados.setLayout(panelDatosRegistradosLayout);
        panelDatosRegistradosLayout.setHorizontalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPais)
                    .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                            .addComponent(cboRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(separadorNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(separadorId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosRegistradosLayout.createSequentialGroup()
                            .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panelBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panelBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelDatosRegistradosLayout.setVerticalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(26, 26, 26)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorId, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPais)
                .addGap(12, 12, 12)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panelGeneral.add(panelDatosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 430, 420));

        panelTablaDatos.setBackground(new java.awt.Color(255, 153, 51));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LISTADO DE PAÍSES");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelTablaDatosLayout = new javax.swing.GroupLayout(panelTablaDatos);
        panelTablaDatos.setLayout(panelTablaDatosLayout);
        panelTablaDatosLayout.setHorizontalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(219, 219, 219))
            .addGroup(panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTablaDatosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelTablaDatosLayout.setVerticalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTablaDatosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelGeneral.add(panelTablaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 31, 660, 430));

        barraSuperiorVentana.setBackground(new java.awt.Color(255, 255, 255));
        barraSuperiorVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraSuperiorVentanaMouseDragged(evt);
            }
        });
        barraSuperiorVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraSuperiorVentanaMousePressed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });

        lblBtnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        lblBtnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnCerrar.setText("X");
        lblBtnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBtnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBtnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBtnCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCerrarLayout = new javax.swing.GroupLayout(btnCerrar);
        btnCerrar.setLayout(btnCerrarLayout);
        btnCerrarLayout.setHorizontalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBtnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        btnCerrarLayout.setVerticalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBtnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout barraSuperiorVentanaLayout = new javax.swing.GroupLayout(barraSuperiorVentana);
        barraSuperiorVentana.setLayout(barraSuperiorVentanaLayout);
        barraSuperiorVentanaLayout.setHorizontalGroup(
            barraSuperiorVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraSuperiorVentanaLayout.createSequentialGroup()
                .addGap(0, 1041, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraSuperiorVentanaLayout.setVerticalGroup(
            barraSuperiorVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelGeneral.add(barraSuperiorVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        // TODO add your handling code here:
        int fila = this.tablaDatos.getSelectedRow();
        Pais paisObject = (Pais)this.tablaDatos.getValueAt(fila, 1);
        this.txtId.setText(Integer.toString(paisObject.getId()));
        this.txtNombre.setText(paisObject.toString());
        this.cboRegion.getModel().setSelectedItem(paisObject.getRegion());
        
        habilitarBotones(false);
        panelBtnRegistrar.setBackground(Color.white);
        LineBorder borderButtonRegistrar = new LineBorder(colorBorderButton);
        panelBtnRegistrar.setBorder(borderButtonRegistrar);

        //this.cboPais
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void lblCerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseClicked
        dispose();
    }//GEN-LAST:event_lblCerrarVentanaMouseClicked

    private void lblCerrarVentanaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseEntered
        btnCerrar.setBackground(Color.red);
        lblBtnCerrar.setForeground(Color.white);
    }//GEN-LAST:event_lblCerrarVentanaMouseEntered

    private void lblCerrarVentanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseExited
        btnCerrar.setBackground(Color.white);
        lblBtnCerrar.setForeground(Color.black);
    }//GEN-LAST:event_lblCerrarVentanaMouseExited

    private void barraSuperiorVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);

    }//GEN-LAST:event_barraSuperiorVentanaMouseDragged

    private void barraSuperiorVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraSuperiorVentanaMousePressed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited

    }//GEN-LAST:event_btnActualizarMouseExited

    private void panelBtnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnActualizarMouseEntered

    }//GEN-LAST:event_panelBtnActualizarMouseEntered

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseExited

    private void panelBtnActualizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnActualizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelBtnActualizar1MouseEntered

    private void lblBtnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBtnCerrarMouseClicked
        gestor.notificarSubscriptores();
        dispose();
    }//GEN-LAST:event_lblBtnCerrarMouseClicked

    private void lblBtnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBtnCerrarMouseEntered
        btnCerrar.setBackground(Color.red);
        lblBtnCerrar.setForeground(Color.white);
    }//GEN-LAST:event_lblBtnCerrarMouseEntered

    private void lblBtnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBtnCerrarMouseExited
        btnCerrar.setBackground(Color.white);
        lblBtnCerrar.setForeground(Color.black);
    }//GEN-LAST:event_lblBtnCerrarMouseExited

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked

    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered

    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited

    }//GEN-LAST:event_btnCerrarMouseExited

    private void barraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseDragged

    private void barraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MousePressed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        boolean esValido = gestor.validarCamposVacios(txtNombre);
        if(esValido) {
            gestor.registrarPais();
            tablaDatos.setModel(gestor.mostrarDatos());
            limpiarEntradas();
            habilitarBotones(true);
            setIdUltimoPais();
        }else {
            this.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "EL NOMBRE INGRESADO NO ES CORRECTO");
        } 
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
        gestor.modificarPais();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        gestor.eliminarPais();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        limpiarEntradas();
        tablaDatos.setCellSelectionEnabled(true);
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void cboRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRegionActionPerformed

    private void btnRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegionMouseClicked
        gestor.solicitarActualizacionRegiones();
        this.setAlwaysOnTop(false);
        gestor.mostrarPaisABMC();
    }//GEN-LAST:event_btnRegionMouseClicked

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        // TODO add your handling code here:
        if(txtNombre.getForeground().equals(new Color(153,153,153))) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.darkGray);
        }
    }//GEN-LAST:event_txtNombreMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaisABMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaisABMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaisABMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaisABMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraSuperiorVentana;
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JPanel btnCerrar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnRegion;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JComboBox<Region> cboRegion;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBtnCerrar;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBtnActualizar;
    private javax.swing.JPanel panelBtnCancelar;
    private javax.swing.JPanel panelBtnEliminar;
    private javax.swing.JPanel panelBtnRegistrar;
    private javax.swing.JPanel panelDatosRegistrados;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelTablaDatos;
    private javax.swing.JSeparator separadorId;
    private javax.swing.JSeparator separadorNombre;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarEntradas() {
        txtId.setText("");
        txtNombre.setText("");
    }

    private void habilitarBotones(boolean estado) {
        btnRegistrar.setEnabled(estado);
        btnActualizar.setEnabled(!estado);
        btnEliminar.setEnabled(!estado);
    }

    String getTxtNombre() {
        return txtNombre.getText();
    }

    String getTxtId() {
        return txtId.getText();
    }

    void actualizarComboRegiones() {
        cboRegion.removeAllItems();
        gestor.conocerRegiones();
        for (Region r : gestor.listaRegiones) {
            cboRegion.addItem(r);
        }
    }

    Pais getPais() {
       return (Pais)this.tablaDatos.getValueAt(this.tablaDatos.getSelectedRow(), 1);
    }

    Region getRegion() {
        return (Region) cboRegion.getSelectedItem();
    }

    private void setIdUltimoPais() {
        txtId.setText(Integer.toString(gestor.conocerUltimoIdPais()));
    }
}
