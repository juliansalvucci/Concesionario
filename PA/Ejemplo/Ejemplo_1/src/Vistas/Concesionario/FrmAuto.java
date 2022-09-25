package Vistas.Concesionario;
import Vistas.FrmGenerica;
import javax.swing.*;

public class FrmAuto extends FrmGenerica 
{
    private GestorVistaAuto gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaAuto getGestorVista() 
    {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaAuto  gestorVista) 
    {
        this.gestorVista = gestorVista;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public JTextField getTxtPrecio(){
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) 
    {
        this.txtPrecio = txtPrecio;
    }

    public JComboBox getCmbNombreMarca()
    {
        return cmbNombreMarca;
    }

    public void setCmbNombreMarca(JComboBox cmbNombreMarca)
    {
        this.cmbNombreMarca = cmbNombreMarca;
    }

// Constructores del formulario 
    public FrmAuto(GestorVistaAuto  gestorVista)
    {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmAuto() 
    {
        initComponents();
    }
    
      // Metodos que gestionan los botones de la barra comando 
    public void viewOpenedBotones()
    {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones()
    {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
    }
  
    public void viewEliminarBotones() 
    {
        this.viewOpenedBotones();
    }
  
    public void viewGuardarBotones()
    {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewBuscarBotones()
    {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    } 
    
    public void viewBuscar() 
    {
        btnNuevo.setEnabled(true); 
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);   
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    private void viewBuscarComboEnter()
    {
       this.viewBuscarPrincipalEnter();
       this.cargarComboModel();
       this.viewMarcaVisible(false);
       cmbNombreMarca.grabFocus();
    }
    
    @Override
    public void onViewOpened() 
    {
       this.viewOpenedBotones();
       this.viewOpenedBotones();
       this.viewCamposEnabled(false);
       this.viewMarcaVisible(true);
       this.cargarCombos();
       this.isExtra();
    }

    @Override
    public void viewCamposEnabled(Boolean tipo)
    {
        txtPrecio.setEnabled(tipo);   
    }

    private void viewMarcaVisible(Boolean tipo)
    {
        txtPrecio.setVisible(tipo);
        cmbNombreMarca.setVisible(!tipo);
    }

    private void viewBasic()
    {
        this.viewNuevoEditarBotones();
        this.viewCamposEnabled(true);
        this.viewMarcaVisible(true);
    }

    @Override
    public void viewNuevoEnter() 
    {
        this.viewBasic();
        this.viewNueva();
    }

    @Override
    public void viewEditarEnter()
    {
        this.viewBasic();
        txtPrecio.grabFocus();
        this.getGestorVista().setModoEditar();
    }

    private void viewBuscarPrincipalEnter()
    {
        this.viewCamposEnabled(false);
        this.clearView();
        this.viewBuscar();
    }


    @Override
    public void viewGuardar() 
    {
        this.viewGuardarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
    }

    @Override
    public void viewEliminar() 
    {
        this.viewEliminarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
        this.viewMarcaVisible(true);
        this.clearView();
    }

    private void viewActualizar() 
    {
        this.setView();
        this.viewCamposEnabled(false);
        this.viewBuscarBotones();
    }

    private void viewNueva()
    {
        this.clearView();
        this.getGestorVista().newModel();
        this.viewMarcaVisible(true);
        txtPrecio.grabFocus();
    }
 
   
    @Override
    public void grabFocus()
    {
        txtPrecio.grabFocus();
    }

    public void cargarComboModel()
    {
        this.gestorVista.setModelMarca(cmbNombreMarca);
    }

   @Override
    public void cancelarView() 
    {
        this.getGestorVista().cancelarView();
        this.onViewOpened();
        this.clearView();
    }
    
   public void extraView() 
   {
        btnBuscar.setEnabled(false);
        this.viewNuevoEnter();
   }

    @Override
    public void deleteView() 
    {
         this.getGestorVista().deleteView();
    }

    @Override
    public void saveView()
    {
        this.getGestorVista().saveView();
    }

    @Override
    public void setView()
    {
       this.getGestorVista().getView();
    }  
 
    private void isExtra()
    {
        if (this.getGestorVista().isExtra())
        {
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
        cmbNombreMarca = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbNombreMarca1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("Gestión Autos");
        setToolTipText("Proyecto");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        cmbNombreMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        cmbNombreMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNombreMarcaItemStateChanged(evt);
            }
        });
        cmbNombreMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNombreMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbNombreMarca);
        cmbNombreMarca.setBounds(110, 70, 460, 23);

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
        btnBuscar.setBounds(570, 20, 30, 40);

        txtPrecio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(110, 110, 460, 23);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Precio");
        jLabel2.setToolTipText("");
        jLabel2.setRequestFocusEnabled(false);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 110, 90, 20);

        txtPrecio1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtPrecio1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtPrecio1);
        txtPrecio1.setBounds(110, 30, 460, 23);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("Modelo");
        jLabel3.setToolTipText("");
        jLabel3.setRequestFocusEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 70, 90, 20);

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel4.setText("Marca");
        jLabel4.setToolTipText("");
        jLabel4.setRequestFocusEnabled(false);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 30, 90, 17);

        cmbNombreMarca1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        cmbNombreMarca1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNombreMarca1ItemStateChanged(evt);
            }
        });
        cmbNombreMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNombreMarca1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbNombreMarca1);
        cmbNombreMarca1.setBounds(110, 30, 460, 23);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Precio"
            }
        ));
        tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tbl);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 150, 600, 220);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 610, 370);
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
        jPanel2.setBounds(10, 390, 340, 40);

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
        jPanel3.setBounds(440, 390, 180, 40);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 653, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbNombreMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNombreMarcaItemStateChanged
        if (this.getGestorVista().isEmpty(cmbNombreMarca)) 
        {
            this.viewBuscarPrincipalEnter();
        }
        else 
        {
            this.getGestorVista().setModel(cmbNombreMarca);
            this.viewActualizar();
            this.viewMarcaVisible(false);
        }
}//GEN-LAST:event_cmbNombreMarcaItemStateChanged

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

    private void cmbNombreMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNombreMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNombreMarcaActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cmbNombreMarca1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNombreMarca1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNombreMarca1ItemStateChanged

    private void cmbNombreMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNombreMarca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNombreMarca1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbNombreMarca;
    private javax.swing.JComboBox cmbNombreMarca1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio1;
    // End of variables declaration//GEN-END:variables



}
