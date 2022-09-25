package Vistas.Concesionario;
import Vistas.FrmGenerica;
import javax.swing.*;

public class FrmCliente extends FrmGenerica {
    private GestorVistaCliente gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaCliente getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaCliente gestorVista) {
        this.gestorVista = gestorVista;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public void setTxtNombreMarca(JTextField txtNombreMarca) {
        this.txtNombreCliente = txtNombreMarca;
    }

    /*
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }
    */
    public JComboBox getCmbNombreCliente() {
        return cmbNombreCliente;
    }

    public void setCmbNombreCliente(JComboBox cmbNombreCliente) {
        this.cmbNombreCliente = cmbNombreCliente;
    }

    /*
    public JComboBox getCmbTipoProyecto() {
        return cmbTipoProyecto;
    }

    public void setCmbTipoProyecto(JComboBox cmbTipoProyecto) {
        this.cmbTipoProyecto = cmbTipoProyecto;
    }
    */
    
    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

    /*
    public JTextField getTxtItemDenominacion() {
        return txtItemDenominacion;
    }

    public void setTxtItemDenominacion(JTextField txtItemDenominacion) {
        this.txtItemDenominacion = txtItemDenominacion;
    }
    */

// Constructores del formulario 
    public FrmCliente(GestorVistaCliente gestorVista) {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmCliente() {
        initComponents();
    }
    
      // Metodos que gestionan los botones de la barra comando 
    public void viewOpenedBotones() {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones(){
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
    }
  
    public void viewEliminarBotones() {
        this.viewOpenedBotones();
    }
  
    public void viewGuardarBotones() {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        
        
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewBuscarBotones() {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    } 
    
    public void viewBuscar() {
        btnNuevo.setEnabled(true); 
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
     
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    @Override
    public void onViewOpened() {
        this.viewOpenedBotones();
        this.viewOpenedBotones();
        this.viewCamposEnabled(false);
        this.viewDenominacionVisible(true);
        this.cargarCombos();
        this.getGestorVista().initializeTabla(tbl);
         this.isExtra();
        
     }

    @Override
    public void viewCamposEnabled(Boolean tipo) {
        //txtCodigo.setEnabled(false);
        txtNombreCliente.setEnabled(tipo);
        //this.cmbTipoProyecto.setEnabled(tipo);
        
    }

    private void viewDenominacionVisible(Boolean tipo){
        txtNombreCliente.setVisible(tipo);
        cmbNombreCliente.setVisible(!tipo);
    }

    private void viewBasic(){
        this.viewNuevoEditarBotones();
        this.viewCamposEnabled(true);
        this.viewDenominacionVisible(true);
    }

    @Override
    public void viewNuevoEnter( ) {
        this.viewBasic();
        this.viewNueva();
    }

    @Override
    public void viewEditarEnter( ) {
        this.viewBasic();
        txtNombreCliente.grabFocus();
        this.getGestorVista().setModoEditar();
    }

    private void viewBuscarPrincipalEnter() {
        this.viewCamposEnabled(false);
        this.clearView();
        this.viewBuscar();
    }

    private void viewBuscarCodigoEnter() {
        this.viewBuscarPrincipalEnter();
        this.viewDenominacionVisible(true);
        //txtCodigo.setEnabled(true);
        //txtCodigo.grabFocus();
    }

    private void viewBuscarComboEnter() {
        this.viewBuscarPrincipalEnter();
        this.cargarComboModel();
        this.viewDenominacionVisible(false);
        //txtCodigo.setEnabled(false);
        cmbNombreCliente.grabFocus();
    }

    @Override
    public void viewGuardar() {
        this.viewGuardarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
    }

    @Override
    public void viewEliminar() {
        this.viewEliminarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
        this.viewDenominacionVisible(true);
        this.clearView();
    }

    private void viewActualizar() {
        this.setView();
        this.viewCamposEnabled(false);
        this.viewBuscarBotones();
    }

    private void viewNueva(){
        this.clearView();
        this.getGestorVista().newModel();
        this.viewDenominacionVisible(true);
        txtNombreCliente.grabFocus();
    }
 
    @Override
    public void cargarCombos() {
        //this.gestorVista.setModelTipoProyecto(cmbTipoProyecto);
    }
    
    @Override
    public void clearView() {
        txtNombreCliente.setText("");
        //txtCodigo.setText("");
        //this.cmbTipoProyecto.setSelectedItem("");
         this.getGestorVista().initializeTabla(tbl);
    }
  
    /*
    void clearItemView() {
       this.txtItemDenominacion.setText("");
    }
    */
    
    @Override
    public void grabFocus(){
        txtNombreCliente.grabFocus();
    }

    public void cargarComboModel(){
        this.gestorVista.setModelMarca(cmbNombreCliente);
    }

   @Override
    public void cancelarView() {
        this.getGestorVista().cancelarView();
        this.onViewOpened();
        this.clearView();
    }
   public void extraView() {
        btnBuscar.setEnabled(false);
             this.viewNuevoEnter();
    }

    @Override
    public void deleteView() {
         this.getGestorVista().deleteView();
    }

    @Override
    public void saveView(){
        this.getGestorVista().saveView();
    }

    @Override
    public void setView(){
       this.getGestorVista().getView();
    }  
 
    private void isExtra() {
        if (this.getGestorVista().isExtra()) {
            this.extraView();
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbNombreCliente = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();

        setTitle("Cliente");
        setToolTipText("Proyecto");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        cmbNombreCliente.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        cmbNombreCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNombreClienteItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbNombreCliente);
        cmbNombreCliente.setBounds(110, 50, 460, 23);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(570, 40, 30, 40);

        txtNombreCliente.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtNombreCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombreCliente);
        txtNombreCliente.setBounds(110, 50, 460, 23);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jLabel2.setRequestFocusEnabled(false);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 50, 90, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 610, 120);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel2.add(btnNuevo);
        btnNuevo.setBounds(10, 10, 75, 23);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(170, 10, 75, 23);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel2.add(btnEliminar);
        btnEliminar.setBounds(250, 10, 75, 23);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEditar.setMaximumSize(new java.awt.Dimension(61, 21));
        btnEditar.setMinimumSize(new java.awt.Dimension(61, 21));
        btnEditar.setPreferredSize(new java.awt.Dimension(61, 21));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
            }
        });
        jPanel2.add(btnEditar);
        btnEditar.setBounds(90, 10, 75, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 320, 340, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        jPanel3.add(btnSalir);
        btnSalir.setBounds(100, 10, 75, 21);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnCancelar.setMaximumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setMinimumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setPreferredSize(new java.awt.Dimension(61, 21));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(10, 10, 75, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(440, 320, 180, 40);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tbl);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 190, 600, 100);

        btnImprimir.setText("I");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir);
        btnImprimir.setBounds(360, 330, 22, 22);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 653, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbNombreClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNombreClienteItemStateChanged
        if (this.getGestorVista().isEmpty(cmbNombreCliente)) {
            this.viewBuscarPrincipalEnter();
        }
        else  {
            this.getGestorVista().setModel(cmbNombreCliente);
            this.viewActualizar();
            this.viewDenominacionVisible(false);
        }
}//GEN-LAST:event_cmbNombreClienteItemStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.viewBuscarComboEnter();
}//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if (evt.getKeyCode()==10) {
            this.viewBuscarComboEnter();
        }
}//GEN-LAST:event_btnBuscarKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
       if (evt.getKeyCode()==10)
          this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
        if (evt.getKeyCode()==10)
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode()==10)
        this.saveView();
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
           this.deleteView();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
            this.deleteView();
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVista().isNuevo() || this.getGestorVista().isOnlyRead())
        this.dispose();
        else
        n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
        if  (n == 1 ){
            this.cancelarView();
            this.dispose();}
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        if(evt.getKeyCode()==10) {
            int n = 0;
            if (this.getGestorVista().isNuevo())
                 this.dispose();
            else
            n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
            if  (n == 1 ){
                this.cancelarView();
                this.dispose();}
        }

    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
        this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
            this.cancelarView();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       this.gestorVista.imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbNombreCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables



}
