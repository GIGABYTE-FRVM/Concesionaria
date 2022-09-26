/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package net.javaguides.concesionaria;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


/**
 *
 * @author matya
 */
public class CombustibleABMC extends javax.swing.JFrame {

    GestorCombustibleABMC gestor;
    Color colorBackgroundButton = new Color(255,153,0);
    Color colorBorderButton = new Color(204,204,204);
    LineBorder borderButtonDisabled = new LineBorder(colorBorderButton);
    


    public CombustibleABMC(GestorCombustibleABMC gestorPadre) {
        initComponents();
        this.setDefaultCloseOperation(2);
        DefaultTableModel modelo = new DefaultTableModel();
        conocerGestor(gestorPadre);
        tablaDatos.setModel(gestor.mostrarDatos());
    }
    
     public void conocerGestor(GestorCombustibleABMC gestor) {
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
        lblNombre = new javax.swing.JLabel();
        separadorId = new javax.swing.JSeparator();
        separadorNombre = new javax.swing.JSeparator();
        panelBtnRegistrar = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        panelBtnActualizar = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        panelBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        panelBtnCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JLabel();
        panelTablaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        lblTituloTabla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatosRegistrados.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosRegistrados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDatosRegistrados.setInheritsPopupMenu(true);

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        txtId.setBorder(null);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        lblTitulo.setText("INFORMACIÓN DEL COMBUSTIBLE");

        lblId.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblId.setText("ID");

        lblNombre.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");

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
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
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

        javax.swing.GroupLayout panelDatosRegistradosLayout = new javax.swing.GroupLayout(panelDatosRegistrados);
        panelDatosRegistrados.setLayout(panelDatosRegistradosLayout);
        panelDatosRegistradosLayout.setHorizontalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(separadorNombre)
                    .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(separadorId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo)
                        .addComponent(lblNombre)
                        .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                            .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panelBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panelBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelDatosRegistradosLayout.setVerticalGroup(
            panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosRegistradosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addGap(24, 24, 24)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorId, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelDatosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        panelGeneral.add(panelDatosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 410, 330));

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


        lblTituloTabla.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        lblTituloTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTabla.setText("LISTADO DE COMBUSTIBLES");

        javax.swing.GroupLayout panelTablaDatosLayout = new javax.swing.GroupLayout(panelTablaDatos);
        panelTablaDatos.setLayout(panelTablaDatosLayout);
        panelTablaDatosLayout.setHorizontalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaDatosLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblTituloTabla)
                .addContainerGap(177, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelTablaDatosLayout.setVerticalGroup(
            panelTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        panelGeneral.add(panelTablaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 34, 650, 330));
        panelTablaDatos.getAccessibleContext().setAccessibleDescription("");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGeneral.getAccessibleContext().setAccessibleName("ABMC Combustible");


        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        gestor.registrarCombustible();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        // TODO add your handling code here:
        int fila = this.tablaDatos.getSelectedRow();
        this.txtId.setText(this.tablaDatos.getValueAt(fila, 0).toString());
        this.txtNombre.setText(this.tablaDatos.getValueAt(fila, 1).toString());
        habilitarBotones(false);
        panelBtnRegistrar.setBackground(Color.WHITE);
        panelBtnRegistrar.setBorder(borderButtonDisabled);


       
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        gestor.registrarCombustible();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked

        // TODO add your handling code here:
        gestor.modificarCombustible();
        tablaDatos.setModel(gestor.mostrarDatos());
        limpiarEntradas();
        habilitarBotones(true);
        panelBtnRegistrar.setBackground(colorBackgroundButton);
        panelBtnRegistrar.setBorder(null);
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        // TODO add your handling code here:
        gestor.eliminarCombustible();
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


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloTabla;
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
    private void habilitarBotones(boolean estado){
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
    
    
 
}
