/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguides.concesionaria;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Thread.sleep;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.javaguides.concesionaria.herramientas.VentaTableModel;
import net.javaguides.hibernate.model.Venta;

/**
 *
 * @author iTeaCode
 */
public class ConsultaVenta extends javax.swing.JFrame {

    /**
     * Creates new form VentaJFrame
     */
    VentaTableModel ventaTableModel;
    GestorVenta gestor;

    Integer page = 1;
    Integer rowCountPerPage = 5;
    Integer totalPage = 1;
    Integer totalData = 0;
    Boolean filtroAplicado = false;

    public ConsultaVenta(GestorVenta gestorPadre) {
        conocerGestor(gestorPadre);
        initComponents();
        
        setLocationRelativeTo(null);

        jComboBoxPage.addItem("5");
        jComboBoxPage.addItem("15");
        jComboBoxPage.addItem("30");
        jComboBoxPage.addItem("50");
        jComboBoxPage.addItem("100");
        jComboBoxPage.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                initPagination();
            }
        });
        
        initPagination();
        //sleep(1000);
        
    }

    public void conocerGestor(GestorVenta gestor) {
        this.gestor = gestor;
    }

    public String getTipo() {
        return (String) comboTipoBusqueda.getSelectedItem();
    }

    public String getConsulta() {
        return txtConsulta.getText();
    }

    public String getFechaDesde() {
        return txtFechaDesde.getText();
    }

    public String getFechaHasta() {
        return txtFechaHasta.getText();
    }
    public Boolean getFiltroConFechas() {
        return habilitarDesdeHasta.isSelected();
    }

    private void initPagination() {
        totalData = gestor.conocerVentas().size();
        rowCountPerPage = Integer.valueOf(jComboBoxPage.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
        totalPage = totalPageD.intValue();

        if (page.equals(1)) {
            jButtonFirst.setEnabled(false);
            jButtonPrevious.setEnabled(false);
        } else {
            jButtonFirst.setEnabled(true);
            jButtonPrevious.setEnabled(true);
        }

        if (page.equals(totalPage)) {
            jButtonLast.setEnabled(false);
            jButtonNext.setEnabled(false);
        } else {
            jButtonLast.setEnabled(true);
            jButtonNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }

        ventaTableModel = new VentaTableModel();
        ventaTableModel.setList(gestor.conocerVentasLimit(page, rowCountPerPage));
        jTableProduct.setModel(ventaTableModel);
        
        //ORDENAMIENTO DE REGISTROS POR COLUMNA
        
        TableRowSorter<VentaTableModel> sorter = new TableRowSorter<>(ventaTableModel);
        jTableProduct.setRowSorter(sorter);

        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);
        jLabelTotalData.setText(("Row count " + totalData));
        autoResizeColumn(jTableProduct);
        
    }

    private void initPaginationFiltradas() {
        jTableProduct.setRowSorter(null);
        if (gestor.conocerVentasFiltradas() != null) {
            totalData = gestor.conocerVentasFiltradas().size();
        } else {
            totalData = 0;
        }
        rowCountPerPage = Integer.valueOf(jComboBoxPage.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
        totalPage = totalPageD.intValue();

        if (page.equals(1)) {
            jButtonFirst.setEnabled(false);
            jButtonPrevious.setEnabled(false);
        } else {
            jButtonFirst.setEnabled(true);
            jButtonPrevious.setEnabled(true);
        }

        if (page.equals(totalPage)) {
            jButtonLast.setEnabled(false);
            jButtonNext.setEnabled(false);
        } else {
            jButtonLast.setEnabled(true);
            jButtonNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }

        ventaTableModel = new VentaTableModel();
        ventaTableModel.setList(gestor.conocerVentasFiltradas(page, rowCountPerPage));
        jTableProduct.setModel(ventaTableModel);

        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);
        jLabelTotalData.setText(("Row count " + totalData));
        autoResizeColumn(jTableProduct);
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
        jTableProduct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelStatusHalaman = new javax.swing.JLabel();
        jLabelTotalData = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonLast = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jComboBoxPage = new javax.swing.JComboBox();
        jButtonPrevious = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        btnCancelar = new javax.swing.JLabel();
        comboTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTituloTablaDatos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        habilitarDesdeHasta = new javax.swing.JCheckBox();
        txtFechaDesde = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFechaHasta = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduct);

        jLabelTotalData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLast);

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNext);
        jPanel1.add(jComboBoxPage);

        jButtonPrevious.setText("Previous");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPrevious);

        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFirst);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelStatusHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabelTotalData, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTotalData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 153, 51));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("Volver");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        comboTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Empleado", "Auto" }));
        comboTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoBusquedaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel2.setText("FILTRAR POR:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("INDIQUE UNA REFERENCIA");

        txtConsulta.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        txtConsulta.setForeground(new java.awt.Color(153, 153, 153));
        txtConsulta.setBorder(null);
        txtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConsultaMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        lblTituloTablaDatos.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloTablaDatos.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        lblTituloTablaDatos.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTablaDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTablaDatos.setText("LISTADO DE VENTAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(lblTituloTablaDatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblTituloTablaDatos)
                .addGap(33, 33, 33))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        habilitarDesdeHasta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                habilitarDesdeHastaStateChanged(evt);
            }
        });
        habilitarDesdeHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarDesdeHastaActionPerformed(evt);
            }
        });

        txtFechaDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaDesde.setEnabled(false);
        txtFechaDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDesdeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("DESDE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("HASTA");

        txtFechaHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaHasta.setEnabled(false);
        txtFechaHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaHastaActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 153, 51));

        btnRegistrar.setBackground(new java.awt.Color(255, 153, 51));
        btnRegistrar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setText("Registrar venta");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(161, 161, 161))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(habilitarDesdeHasta)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 505, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(habilitarDesdeHasta)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(2, 2, 2)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if (page < totalPage) {
            page++;
            if (filtroAplicado) {
                initPaginationFiltradas();
            } else {
                initPagination();
            }
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        page = totalPage;
        initPagination();
    }//GEN-LAST:event_jButtonLastActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        if (page > 1) {
            page--;
            if (filtroAplicado) {
                initPaginationFiltradas();
            } else {
                initPagination();
            }
        }


    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
        page = 1;
        if (filtroAplicado) {
            initPaginationFiltradas();
        } else {
            initPagination();
        }
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        gestor.mostrarPantalla(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void comboTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoBusquedaActionPerformed

    private void txtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaMouseClicked
        // TODO add your handling code here:
        txtConsulta.setText("");
    }//GEN-LAST:event_txtConsultaMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        if(txtConsulta.getText().equals("")) {
            initPagination();
            filtroAplicado = true;
        }else {
            initPaginationFiltradas();
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void habilitarDesdeHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarDesdeHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_habilitarDesdeHastaActionPerformed

    private void habilitarDesdeHastaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_habilitarDesdeHastaStateChanged
        // TODO add your handling code here:
            txtFechaDesde.setEnabled(habilitarDesdeHasta.isSelected());
            txtFechaHasta.setEnabled(habilitarDesdeHasta.isSelected());

    }//GEN-LAST:event_habilitarDesdeHastaStateChanged

    private void txtFechaDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeActionPerformed

    private void txtFechaHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHastaActionPerformed

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        habilitarOrdenamiento();
    }//GEN-LAST:event_jTableProductMouseClicked

    private void autoResizeColumn(JTable jTable1) {
        JTableHeader header = jTable1.getTableHeader();
        int rowCount = jTable1.getRowCount();

        final Enumeration columns = jTable1.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable1.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(jTable1, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable1.getCellRenderer(row, col).getTableCellRendererComponent(jTable1,
                        jTable1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + jTable1.getIntercellSpacing().width);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JComboBox<String> comboTipoBusqueda;
    private javax.swing.JCheckBox habilitarDesdeHasta;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JComboBox jComboBoxPage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelStatusHalaman;
    private javax.swing.JLabel jLabelTotalData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JLabel lblTituloTablaDatos;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JFormattedTextField txtFechaDesde;
    private javax.swing.JFormattedTextField txtFechaHasta;
    // End of variables declaration//GEN-END:variables

    public void habilitarOrdenamiento() {
        TableRowSorter<VentaTableModel> sorter = new TableRowSorter<>(ventaTableModel);
        jTableProduct.setRowSorter(sorter);

        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);
        jLabelTotalData.setText(("Row count " + totalData));
    }
}
