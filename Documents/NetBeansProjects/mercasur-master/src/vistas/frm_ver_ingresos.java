/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.cl_ingreso;
import clases.cl_varios;
import forms.frm_reg_ingreso;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CONTABILIDAD 02
 */
public class frm_ver_ingresos extends javax.swing.JInternalFrame {

    cl_varios c_varios = new cl_varios();
    cl_ingreso c_ingreso = new cl_ingreso();
    public static DefaultTableModel mostrar;
    Integer i;

    /**
     * Creates new form frm_ver_compra
     */
    public frm_ver_ingresos() {
        initComponents();
        String query = "select i.periodo, i.id_ingreso, i.fecha, pr.ruc_pro, pr.raz_soc_pro, td.abreviado as documento, i.serie, i.numero, i.total "
                + "from ingresos as i "
                + "inner join proveedores as pr on pr.id_proveedor = i.id_proveedor "
                + "inner join tipo_documento as td on td.id_documento = i.id_documento "
                + "where i.periodo = '" + c_varios.ver_periodo_actual() + "' "
                + "order by i.fecha desc";
        c_ingreso.ver_ingresos(t_ingresos, query);
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
        t_ingresos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        txt_reg = new javax.swing.JButton();
        txt_close = new javax.swing.JButton();
        btn_det = new javax.swing.JButton();
        btn_eli = new javax.swing.JButton();
        cbx_bus = new javax.swing.JComboBox();

        setTitle("Ingreso de Productos");

        t_ingresos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(t_ingresos);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        txt_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        txt_reg.setText("Registrar");
        txt_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_regActionPerformed(evt);
            }
        });

        txt_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        txt_close.setText("Cerrar");
        txt_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_closeActionPerformed(evt);
            }
        });

        btn_det.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clipboard_text.png"))); // NOI18N
        btn_det.setText("Ver Detalle");
        btn_det.setEnabled(false);
        btn_det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detActionPerformed(evt);
            }
        });

        btn_eli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/bin_closed.png"))); // NOI18N
        btn_eli.setText("Eliminar");
        btn_eli.setEnabled(false);
        btn_eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliActionPerformed(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROVEEDOR", "NRO. DOCUMENTO", "PERIODO (AÑOMES) (AAAAMM)", "FECHA (DD/MM/AAAA)" }));
        cbx_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_busActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_reg))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_det)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_close)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_det, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_txt_closeActionPerformed

    private void txt_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_regActionPerformed
        frm_reg_ingreso reg_ingreso = new frm_reg_ingreso();
        c_varios.llamar_ventana(reg_ingreso);
        this.dispose();
    }//GEN-LAST:event_txt_regActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String bus = txt_bus.getText();
            String query = "";
            if (cbx_bus.getSelectedIndex() == 0) {
                query = "select i.periodo, i.codigo, i.fecha, i.proveedor, pr.raz_soc_pro, m.corto as moneda, td.abreviado as documento, i.serie, i.numero, i.total "
                        + "from ingresos as i "
                        + "inner join proveedor as pr on pr.ruc_pro = i.proveedor "
                        + "inner join tipo_documento as td on td.id = i.tipo_documento "
                        + "inner join moneda as m on m.idmon = i.moneda "
                        + "where pr.raz_soc_pro like '%" + bus + "%' or i.proveedor = '" + bus + "' "
                        + "order by i.fecha desc";
            }
            if (cbx_bus.getSelectedIndex() == 1) {
                query = "select i.periodo, i.codigo, i.fecha, i.proveedor, pr.raz_soc_pro, m.corto as moneda, td.abreviado as documento, i.serie, i.numero, i.total "
                        + "from ingresos as i "
                        + "inner join proveedor as pr on pr.ruc_pro = i.proveedor "
                        + "inner join tipo_documento as td on td.id = i.tipo_documento "
                        + "inner join moneda as m on m.idmon = i.moneda "
                        + "where i.numero = '" + bus + "' "
                        + "order by i.fecha desc";
            }
            if (cbx_bus.getSelectedIndex() == 2) {
                query = "select i.periodo, i.codigo, i.fecha, i.proveedor, pr.raz_soc_pro, m.corto as moneda, td.abreviado as documento, i.serie, i.numero, i.total "
                        + "from ingresos as i "
                        + "inner join proveedor as pr on pr.ruc_pro = i.proveedor "
                        + "inner join tipo_documento as td on td.id = i.tipo_documento "
                        + "inner join moneda as m on m.idmon = i.moneda "
                        + "where i.periodo = '" + bus + "' "
                        + "order by i.fecha desc";
            }
            if (cbx_bus.getSelectedIndex() == 3) {
                query = "select i.periodo, i.codigo, i.fecha, i.proveedor, pr.raz_soc_pro, m.corto as moneda, td.abreviado as documento, i.serie, i.numero, i.total "
                        + "from ingresos as i "
                        + "inner join proveedor as pr on pr.ruc_pro = i.proveedor "
                        + "inner join tipo_documento as td on td.id = i.tipo_documento "
                        + "inner join moneda as m on m.idmon = i.moneda "
                        + "where i.fecha = '" + bus + "' "
                        + "order by i.fecha desc";
            }
            c_ingreso.ver_ingresos(t_ingresos, query);
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void btn_eliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliActionPerformed

    }//GEN-LAST:event_btn_eliActionPerformed

    private void btn_detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detActionPerformed

    }//GEN-LAST:event_btn_detActionPerformed

    private void cbx_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_busActionPerformed
        txt_bus.setText("");
        txt_bus.requestFocus();
    }//GEN-LAST:event_cbx_busActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_det;
    private javax.swing.JButton btn_eli;
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_ingresos;
    private javax.swing.JTextField txt_bus;
    private javax.swing.JButton txt_close;
    private javax.swing.JButton txt_reg;
    // End of variables declaration//GEN-END:variables
}
