/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vistas.Concesionario;
import Modelos.Concesionario.Auto;
import Modelos.Concesionario.GestorAuto;
import Vistas.GestorVista;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 * @author julia
 */

public class GestorVistaAuto  extends GestorVista {
    FrmAuto form;  
    GestorAuto gestor= new GestorAuto();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Auto getModel() {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Auto) cmb.getSelectedItem());
    }

    private void setModel(Auto model) {
        this.getGestor().setModel(model);
    }

    public GestorAuto getGestor() {
        return gestor;
    }

    public void setGestor(GestorAuto gestor) {
        this.gestor = gestor;
    }

    public FrmAuto getForm() {
        return form;
    }

    public void setForm(FrmAuto form) {
        this.form = form;
    }
  
    @Override
    public void newModel() {
        this.gestor.newModel();
        this.setModoNuevo();
    } 

    @Override
    public void cancelarView() {
        
    }

    @Override
    public void deleteView() {
         this.getGestor().eliminar();
         this.getForm().viewEliminar();
    }
    
    @Override
    public int setModel() { 
        if (this.isDatosValidos()) {
            this.getGestor().setPrecio(Double.parseDouble(this.getForm().getTxtPrecio().getText()));     
            return 0;}
        else {
            return 1;
        } 
    }
    
    @Override
    public void saveView() {
        int err;
        err= this.setModel();
        if (err ==0){ 
           this.getGestor().saveModel(this.getOpcABM());
           this.actualizarView();
        }
    }
    
    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtPrecio())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
            this.getForm().getTxtPrecio().grabFocus();
            return false; 
           } 
        return true;
    }

    public void setModelMarca(JComboBox cmb) {
        cmb.setModel(gestor.getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmAuto(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
      
    @Override
    public void getView() {
        this.getForm().getTxtPrecio().setText(this.getGestor().getPrecio());
    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) {
            //this.getGestor().setDetalle(this.getForm().getTbl());
        }
   
    } 

   public void imprimir() 
   {
        this.abrirListado(this.pathReportes+"ListadoTipoDominio.jasper");
        this.agregarParametroListado("titulo", "Proyecto");
        this.agregarParametroListado("usuario", "Yo");
        this.agregarDatosListado(this.gestor.listar());
        this.imprimirListado();
    }
}
