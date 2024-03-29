/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import clases.cl_ac_proveedor;
import clases.cl_compra;
import clases.cl_conectar;
import clases.cl_moneda;
import clases.cl_proveedor;
import clases.cl_tipo_documento;
import clases.cl_varios;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mercasur.frm_menu;
import models.m_moneda;
import models.m_tipo_documento;
import nicon.notify.core.Notification;
import vistas.frm_ver_compras;

/**
 *
 * @author CONTABILIDAD 02
 */
public class frm_reg_compra extends javax.swing.JInternalFrame {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();
    cl_compra c_compra = new cl_compra();
    cl_proveedor c_proveedor = new cl_proveedor();
    cl_tipo_documento c_documento = new cl_tipo_documento();

    m_tipo_documento m_tido = new m_tipo_documento();
    m_moneda m_moneda = new m_moneda();

    Double monto, tc_compra;
    int idmon;
    String periodo, glosa;

    TextAutoCompleter tac_proveedores = null;

    /**
     * Creates new form frm_reg_compra
     */
    public frm_reg_compra() {
        initComponents();

        txt_per.setText(c_varios.obtener_periodo());
        txt_fec_com.setText(c_varios.formato_fecha_vista(c_varios.getFechaActual()));

        m_tido.cbx_documentos(cbx_tido);
        m_moneda.cbx_moneda(cbx_moneda);
    }

    private void cargar_proveedores() {
        if (tac_proveedores != null) {
            tac_proveedores.removeAllItems();
        }
        tac_proveedores = new TextAutoCompleter(txt_razon_social, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                Object itemSelected = selectedItem;
                if (itemSelected instanceof cl_ac_proveedor) {
                    c_proveedor.setRuc(((cl_ac_proveedor) itemSelected).getRuc());
                    c_proveedor.cargar_datos_proveedor();
                    txt_ruc_proveedor.setText(c_proveedor.getRuc());
                    cbx_moneda.setEnabled(true);
                    cbx_moneda.requestFocus();
                } else {
                    System.out.println("El item es de un tipo desconocido");
                }
            }
        });
        tac_proveedores.setMode(0);
        try {
            Statement st = c_conectar.conexion();
            String query = "select id_proveedor, ruc_pro, raz_soc_pro, dir_pro "
                    + "from proveedores "
                    + "order by ruc_pro asc";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                tac_proveedores.addItem(new cl_ac_proveedor(rs.getInt("id_proveedor"), rs.getString("ruc_pro"), rs.getString("raz_soc_pro")));
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
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

        txt_fec_com = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_sub = new javax.swing.JTextField();
        txt_per = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_ndoc = new javax.swing.JTextField();
        cbx_moneda = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tc_compra = new javax.swing.JTextField();
        txt_ruc_proveedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_ser = new javax.swing.JTextField();
        cbx_tido = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txt_razon_social = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_igv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_glosa = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_buscar_proveedor = new javax.swing.JButton();
        btn_crear_proveedor = new javax.swing.JButton();

        setTitle("Registro de Documento de Compra");

        try {
            txt_fec_com.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fec_com.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fec_com.setEnabled(false);
        txt_fec_com.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fec_comKeyPressed(evt);
            }
        });

        jLabel3.setText("Tipo Doc.");

        txt_sub.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_sub.setEnabled(false);

        try {
            txt_per.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_per.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_per.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_perKeyPressed(evt);
            }
        });

        jLabel11.setText("Periodo:");

        txt_ndoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ndoc.setEnabled(false);
        txt_ndoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ndocKeyPressed(evt);
            }
        });

        cbx_moneda.setEnabled(false);
        cbx_moneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_monedaKeyPressed(evt);
            }
        });

        jLabel1.setText("Proveedor:");

        jLabel6.setText("Moneda:");

        jLabel5.setText("Nro. Doc:");

        txt_tc_compra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tc_compra.setEnabled(false);
        txt_tc_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tc_compraKeyPressed(evt);
            }
        });

        txt_ruc_proveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc_proveedor.setEnabled(false);
        txt_ruc_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ruc_proveedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ruc_proveedorKeyTyped(evt);
            }
        });

        jLabel10.setText("T.C.");

        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.setEnabled(false);
        txt_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_serKeyTyped(evt);
            }
        });

        cbx_tido.setEnabled(false);
        cbx_tido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tidoKeyPressed(evt);
            }
        });

        jLabel4.setText("Serie:");

        txt_razon_social.setEnabled(false);
        txt_razon_social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_razon_socialKeyPressed(evt);
            }
        });

        jLabel2.setText("Fecha:");

        jLabel7.setText("Sub Total:");

        jLabel8.setText("IGV");

        txt_igv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_igv.setEnabled(false);

        jLabel9.setText("Total:");

        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tot.setEnabled(false);
        txt_tot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totKeyTyped(evt);
            }
        });

        jLabel12.setText("Glosa:");

        txt_glosa.setEnabled(false);
        txt_glosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_glosaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_glosaKeyTyped(evt);
            }
        });

        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.setEnabled(false);
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_buscar_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/arrow_redo.png"))); // NOI18N
        btn_buscar_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_proveedorActionPerformed(evt);
            }
        });

        btn_crear_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_crear_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_proveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_registrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_per, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_ruc_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_razon_social))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(cbx_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel10)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txt_tc_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addGap(247, 247, 247)
                                                            .addComponent(jLabel9)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 158, Short.MAX_VALUE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_crear_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_cerrar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(24, 24, 24)
                        .addComponent(txt_glosa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_per, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbx_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tc_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_glosa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fec_comKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fec_comKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fec_com.getText().length() == 10) {
                cargar_proveedores();
                txt_razon_social.setEnabled(true);
                txt_razon_social.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_fec_comKeyPressed

    private void txt_perKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_perKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_per.getText().length() == 6) {
                cbx_tido.setEnabled(true);
                cbx_tido.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_perKeyPressed

    private void txt_ndocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ndocKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_ndoc.getText().isEmpty()) {
                txt_fec_com.setEnabled(true);
                txt_fec_com.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_ndocKeyPressed


    private void cbx_monedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_monedaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cl_moneda c_mon = (cl_moneda) cbx_moneda.getSelectedItem();
            int id_moneda = c_mon.getCodigo();
            c_mon.setCodigo(id_moneda);
            if (id_moneda == 1) {
                txt_tc_compra.setText("1.000");
                txt_tc_compra.setEnabled(false);
                txt_tot.setEnabled(true);
                txt_tot.requestFocus();

            } else {
                txt_tc_compra.setText("");
                txt_tc_compra.setEnabled(true);
                txt_tc_compra.requestFocus();
            }
        }
    }//GEN-LAST:event_cbx_monedaKeyPressed

    private void txt_tc_compraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tc_compraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_tc_compra.getText().length() == 5) {
                txt_tot.setEnabled(true);
                txt_tot.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_tc_compraKeyPressed


    private void txt_ruc_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_proveedorKeyPressed

    }//GEN-LAST:event_txt_ruc_proveedorKeyPressed

    private void txt_ruc_proveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_proveedorKeyTyped
        if (txt_ruc_proveedor.getText().length() == 11) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_ruc_proveedorKeyTyped

    private void txt_serKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_ser.getText().isEmpty()) {
                txt_ndoc.setEnabled(true);
                txt_ndoc.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_serKeyPressed

    private void cbx_tidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cl_tipo_documento c_tido = (cl_tipo_documento) cbx_tido.getSelectedItem();
            int id_tido = c_tido.getId();
            txt_ser.setEnabled(true);
            txt_ser.requestFocus();
        }
    }//GEN-LAST:event_cbx_tidoKeyPressed

    private void txt_serKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_serKeyTyped

    private void txt_glosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_glosaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_glosa.getText().length() > 5) {
                btn_registrar.setEnabled(true);
                btn_registrar.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_glosaKeyPressed


    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        btn_registrar.setEnabled(false);
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Registrar el Documento de Compra?");

        if (JOptionPane.OK_OPTION == confirmado) {

            cl_tipo_documento c_tido = (cl_tipo_documento) cbx_tido.getSelectedItem();
            cl_moneda c_mon = (cl_moneda) cbx_moneda.getSelectedItem();
            int id_tido = c_tido.getId();
            int id_moneda = c_mon.getCodigo();

            c_compra.setPeriodo(txt_per.getText().trim());
            c_compra.setCodigo(c_compra.obtener_codigo());
            c_compra.setDocumento(id_tido);
            c_compra.setSerie(txt_ser.getText().trim().toUpperCase());
            c_compra.setNumero(Integer.parseInt(txt_ndoc.getText()));
            c_compra.setProveedor(txt_ruc_proveedor.getText());
            c_compra.setMoneda(id_moneda);
            c_compra.setUsuario(frm_menu.c_empleado.getId_empleado() + "");
            c_compra.setTc_compra(Double.parseDouble(txt_tc_compra.getText()));
            c_compra.setFecha(c_varios.formato_fecha_mysql(txt_fec_com.getText()));
            c_compra.setTotal(Double.parseDouble(txt_tot.getText()));
            c_compra.setGlosa(txt_glosa.getText().toUpperCase().trim());

            if (c_compra.insertar()) {
                Notification.show("Registro de Compras", "Compra Registrada Nro: " + c_compra.getPeriodo() + c_varios.ceros_izquieda_numero(3, c_compra.getCodigo()));
                btn_cerrar.doClick();
            }
        } else {
            btn_registrar.setEnabled(true);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        frm_ver_compras ver_compras = new frm_ver_compras();
        c_varios.llamar_ventana(ver_compras);
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void txt_glosaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_glosaKeyTyped
        if (txt_glosa.getText().length() == 245) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_glosaKeyTyped

    private void btn_buscar_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_proveedorActionPerformed

    }//GEN-LAST:event_btn_buscar_proveedorActionPerformed

    private void btn_crear_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_proveedorActionPerformed
        Frame f = JOptionPane.getRootFrame();
        frm_reg_proveedor dialog = new frm_reg_proveedor(f, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btn_crear_proveedorActionPerformed

    private void txt_razon_socialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razon_socialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_razon_social.getText().length() > 11) {
                cl_tipo_documento c_tido = (cl_tipo_documento) cbx_tido.getSelectedItem();
                c_compra.setProveedor(txt_ruc_proveedor.getText());
                c_compra.setNumero(Integer.parseInt(txt_ndoc.getText()));
                c_compra.setSerie(txt_ser.getText());
                c_compra.setDocumento(c_tido.getId());
                if (c_compra.comprobar_documento()) {
                    btn_registrar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "ESTE DOCUMENTO YA ESTA REGISTRADO");
                    cbx_tido.requestFocus();
                } else {
                    cbx_moneda.setEnabled(true);
                    cbx_moneda.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txt_razon_socialKeyPressed

    private void txt_totKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_glosa.setEnabled(true);
            txt_glosa.requestFocus();
        }
    }//GEN-LAST:event_txt_totKeyPressed

    private void txt_totKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totKeyTyped
        c_varios.solo_precio(evt);
    }//GEN-LAST:event_txt_totKeyTyped

    private void txt_totKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totKeyReleased
        if (txt_tot.getText().length() > 0) {
            Double total = Double.parseDouble(txt_tot.getText());
            Double subtotal = total / 1.18;
            Double igv = subtotal * 0.18;

            txt_igv.setText(c_varios.formato_totales(igv));
            txt_sub.setText(c_varios.formato_totales(subtotal));
        }
    }//GEN-LAST:event_txt_totKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar_proveedor;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_crear_proveedor;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox cbx_moneda;
    public static javax.swing.JComboBox cbx_tido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField txt_fec_com;
    private javax.swing.JTextField txt_glosa;
    private javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_ndoc;
    private javax.swing.JFormattedTextField txt_per;
    public static javax.swing.JTextField txt_razon_social;
    public static javax.swing.JTextField txt_ruc_proveedor;
    private javax.swing.JTextField txt_ser;
    private javax.swing.JTextField txt_sub;
    private javax.swing.JTextField txt_tc_compra;
    private javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
}
