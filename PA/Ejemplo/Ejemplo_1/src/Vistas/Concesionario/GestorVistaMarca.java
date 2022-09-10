package Vistas.Concesionario;
import Modelos.Concesionario.GestorMarca;
import Modelos.Concesionario.Marca;
import javax.swing.*;
import Vistas.GestorVista;

public class GestorVistaMarca  extends GestorVista {
    FrmMarca form;  
    GestorMarca gestor= new GestorMarca();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Marca getModel() {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Marca) cmb.getSelectedItem());
    }

    private void setModel(Marca model) {
        this.getGestor().setModel(model);
    }

    public GestorMarca getGestor() {
        return gestor;
    }

    public void setGestor(GestorMarca gestor) {
        this.gestor = gestor;
    }

    public FrmMarca getForm() {
        return form;
    }

    public void setForm(FrmMarca form) {
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
            this.getGestor().setNombreMarca(this.getForm().getTxtNombreMarca().getText());     
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
        if (this.isEmpty(this.getForm().getTxtNombreMarca())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
            this.getForm().getTxtNombreMarca().grabFocus();
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
        this.setForm(new FrmMarca(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
      
    @Override
    public void getView() {
        this.getForm().getTxtNombreMarca().setText(this.getGestor().getNombreMarca());
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
