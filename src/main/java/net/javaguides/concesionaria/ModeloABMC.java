/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package net.javaguides.concesionaria;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;

/**
 *
 * @author matya
 */
public class ModeloABMC extends javax.swing.JFrame {

    GestorModeloABMC gestor;
    Color colorBackgroundButton = new Color(255, 153, 0);
    Color colorBorderButton = new Color(204, 204, 204);
    LineBorder borderButton = new LineBorder(colorBorderButton);
    int xMouse, yMouse;

    public ModeloABMC(GestorModeloABMC gestorPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(2);
        DefaultTableModel modelo = new DefaultTableModel();
        conocerGestor(gestorPadre);
        tablaDatos.setModel(gestor.mostrarDatos());
        setIdUltimaMarca();
        
        actualizarComboMarcas();
    }

    public void conocerGestor(GestorModeloABMC gestor) {
        this.gestor = gestor;
    }

    /**
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPais = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelDatosRegistrados = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAñoLanzamiento = new javax.swing.JTextField();
        txtVersion = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        separadorId = new javax.swing.JSeparator();
        lblNombre = new javax.swing.JLabel();
        separadorNombre = new javax.swing.JSeparator();
        lblVersion = new javax.swing.JLabel();
        separadorVersion = new javax.swing.JSeparator();
        lblAñoLanzamiento = new javax.swing.JLabel();
        separadorAñoLanzamiento = new javax.swing.JSeparator();
        panelBtnCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JLabel();
        panelBtnRegistrar = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        panelBtnActualizar = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        panelBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        cboMarca = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        btnMarca = new javax.swing.JLabel();
        panelTablaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        lblTituloTabla = new javax.swing.JLabel();
        barraSuperiorVentana = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JPanel();
        lblBtnCerrar = new javax.swing.JLabel();

        cboPais.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        cboPais.setForeground(new java.awt.Color(51, 51, 51));
        cboPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Alemania", "Brasil", "EEUU" }));
        cboPais.setBorder(null);
        cboPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaisActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel6.setText("PAIS");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ABMC País");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatosRegistrados.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(102, 102, 102));
        txtId.setBorder(null);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese el nombre del modelo");
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
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtAñoLanzamiento.setForeground(new java.awt.Color(153, 153, 153));
        txtAñoLanzamiento.setText("Ingrese el año de lanzamiento del modelo");
        txtAñoLanzamiento.setBorder(null);
        txtAñoLanzamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAñoLanzamientoMouseClicked(evt);
            }
        });
        txtAñoLanzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoLanzamientoActionPerformed(evt);
            }
        });
        txtAñoLanzamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoLanzamientoKeyTyped(evt);
            }
        });

        txtVersion.setForeground(new java.awt.Color(153, 153, 153));
        txtVersion.setText("Ingrese la versión del modelo");
        txtVersion.setBorder(null);
        txtVersion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVersionMouseClicked(evt);
            }
        });
        txtVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVersionActionPerformed(evt);
            }
        });

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        lblTitulo.setText("INFORMACIÓN DEL MODELO");

        lblId.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblId.setText("ID");

        lblNombre.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");

        lblVersion.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblVersion.setText("VERSIÓN");

        lblAñoLanzamiento.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblAñoLanzamiento.setText("AÑO DE LANZAMIENTO");

        panelBtnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnCancelar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 153, 0));
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
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        panelBtnCancelarLayout.setVerticalGroup(
            panelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        panelBtnRegistrar.setBackground(new java.awt.Color(255, 153, 0));

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
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        panelBtnRegistrarLayout.setVerticalGroup(
            panelBtnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBtnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnActualizar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 153, 0));
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
            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        panelBtnActualizarLayout.setVerticalGroup(
            panelBtnActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        panelBtnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnEliminar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 153, 0));
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
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        panelBtnEliminarLayout.setVerticalGroup(
            panelBtnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        cboMarca.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        cboMarca.setForeground(new java.awt.Color(51, 51, 51));
        cboMarca.setBorder(null);
        cboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMarcaActionPerformed(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        lblMarca.setText("MARCA");

        btnMarca.setBackground(new java.awt.Color(255, 255, 255));
        btnMarca.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnMarca.setForeground(new java.awt.Color(255, 153, 51));
        btnMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMarca.setText("ABMC Marca");
        btnMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarcaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDatosRegistradosLayout = new javax.swing.GroupLayout(panelDatosRegistrados);
        panelDatosRegistrados.setLayout(panelDatosRegistradosLayout);
        panelDatosRegistradosLayout.setHorizontalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(panelBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(panelBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(separadorAñoLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAñoLanzamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addComponent(txtVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre)
                                    .addComponent(separadorNombre)
                                    .addComponent(lblVersion)
                                    .addComponent(separadorVersion)
                                    .addComponent(lblAñoLanzamiento)
                                    .addComponent(separadorId)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                                .addComponent(lblMarca)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelDatosRegistradosLayout.setVerticalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorId, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                        .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separadorVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAñoLanzamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAñoLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separadorAñoLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        jPanel1.add(panelDatosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 430, 560));

        panelTablaDatos.setBackground(new java.awt.Color(255, 153, 0));

        tablaDatos.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
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

        lblTituloTabla.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloTabla.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        lblTituloTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTabla.setText("LISTADO DE MODELOS");

        javax.swing.GroupLayout panelTablaDatosLayout = new javax.swing.GroupLayout(panelTablaDatos);
        panelTablaDatos.setLayout(panelTablaDatosLayout);
        panelTablaDatosLayout.setHorizontalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloTabla)
                .addGap(195, 195, 195))
        );
        panelTablaDatosLayout.setVerticalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelTablaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 660, 560));

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

        jPanel1.add(barraSuperiorVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Modelo modeloObject = (Modelo) this.tablaDatos.getValueAt(fila, 1);
        this.txtId.setText(this.tablaDatos.getValueAt(fila, 0).toString());
        this.txtNombre.setText(modeloObject.toString());
        this.txtVersion.setText(this.tablaDatos.getValueAt(fila, 2).toString());
        this.txtAñoLanzamiento.setText(this.tablaDatos.getValueAt(fila, 3).toString());
        this.cboMarca.getModel().setSelectedItem(modeloObject.getMarca());
        habilitarBotones(false);
        panelBtnRegistrar.setBackground(Color.white);
        panelBtnRegistrar.setBorder(borderButton);
        btnRegistrar.setForeground(colorBackgroundButton);
        //this.cboModelo
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void txtAñoLanzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoLanzamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoLanzamientoActionPerformed

    private void txtVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVersionActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        limpiarEntradas();
        tablaDatos.setCellSelectionEnabled(true);
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        btnRegistrar.setForeground(Color.white);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        // TODO add your handling code here:
        boolean esValido = gestor.validarCamposVacios(txtNombre, txtVersion, txtAñoLanzamiento);
        if(esValido){
            gestor.registrarModelo();
            tablaDatos.setModel(gestor.mostrarDatos());
            habilitarBotones(true);
            panelBtnRegistrar.setBackground(colorBackgroundButton);
            btnRegistrar.setForeground(Color.white);
            panelBtnRegistrar.setBorder(null);
            setIdUltimaMarca();
        }else {
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS DEL FORMULARIO DEBEN SER COMPLETADOS");
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
        gestor.modificarModelo();
        tablaDatos.setModel(gestor.mostrarDatos());
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        btnRegistrar.setForeground(Color.white);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        gestor.eliminarModelo();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        btnRegistrar.setForeground(Color.white);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void cboPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPaisActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        gestor.mostrarMarcaABMC();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void cboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMarcaActionPerformed

    private void btnMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcaMouseClicked
        this.setAlwaysOnTop(false);
        gestor.mostrarMarcaABMC();
    }//GEN-LAST:event_btnMarcaMouseClicked

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

    private void barraSuperiorVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraSuperiorVentanaMouseDragged

    private void barraSuperiorVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraSuperiorVentanaMousePressed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        // TODO add your handling code here:
        if(txtNombre.getForeground().equals(new Color(153,153,153))) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.darkGray);
        }
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtVersionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVersionMouseClicked
        // TODO add your handling code here:
        if(txtVersion.getForeground().equals(new Color(153,153,153))) {
            txtVersion.setText("");
            txtVersion.setForeground(Color.darkGray);
        }
    }//GEN-LAST:event_txtVersionMouseClicked

    private void txtAñoLanzamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAñoLanzamientoMouseClicked
        // TODO add your handling code here:
        if(txtAñoLanzamiento.getForeground().equals(new Color(153,153,153))) {
            txtAñoLanzamiento.setText("");
            txtAñoLanzamiento.setForeground(Color.darkGray);
        }
    }//GEN-LAST:event_txtAñoLanzamientoMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        validarString(c, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAñoLanzamientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoLanzamientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        validarEntero(c, evt);
    }//GEN-LAST:event_txtAñoLanzamientoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraSuperiorVentana;
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JPanel btnCerrar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnMarca;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JComboBox<Marca> cboMarca;
    private javax.swing.JComboBox<String> cboPais;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAñoLanzamiento;
    private javax.swing.JLabel lblBtnCerrar;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloTabla;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel panelBtnActualizar;
    private javax.swing.JPanel panelBtnCancelar;
    private javax.swing.JPanel panelBtnEliminar;
    private javax.swing.JPanel panelBtnRegistrar;
    private javax.swing.JPanel panelDatosRegistrados;
    private javax.swing.JPanel panelTablaDatos;
    private javax.swing.JSeparator separadorAñoLanzamiento;
    private javax.swing.JSeparator separadorId;
    private javax.swing.JSeparator separadorNombre;
    private javax.swing.JSeparator separadorVersion;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtAñoLanzamiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables

    public void limpiarEntradas() {
        txtId.setText("");
        txtNombre.setText("");
        txtVersion.setText("");
        txtAñoLanzamiento.setText("");

    }
    public void actualizarComboMarcas() {
        cboMarca.removeAllItems();
        gestor.conocerMarcas();
        for(Marca m : gestor.listaMarcas){
            cboMarca.addItem(m);
        }
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

    String getTxtAñoLanzamiento() {
        return txtAñoLanzamiento.getText();
    }

    String getTxtVersion() {
        return txtVersion.getText();
    }
    public Marca getMarca() {
        return (Marca) cboMarca.getSelectedItem();
    }
    Object getModelo() {
        return this.tablaDatos.getValueAt(this.tablaDatos.getSelectedRow(), 1);
    }

    private void setIdUltimaMarca() {
        txtId.setText(Integer.toString(gestor.conocerUltimoIdModelo()));
    }

    public void validarString(char c, java.awt.event.KeyEvent evt){
        if ((c<'a' ||  c>'z') && (c<'A' ||  c>'Z')) evt.consume();
    }
    
    public void validarEntero(char c, java.awt.event.KeyEvent evt) {
        if (c<'0' || c>'9') evt.consume();
    }
}
