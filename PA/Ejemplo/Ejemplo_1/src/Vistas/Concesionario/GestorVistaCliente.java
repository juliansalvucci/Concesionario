/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas.Concesionario;

import Modelos.Concesionario.Cliente;
import Modelos.Concesionario.GestorCliente;
import Vistas.GestorVista;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author julia
 */

public class GestorVistaCliente extends GestorVista 
{
    FrmCliente form;  
    GestorCliente gestor= new GestorCliente();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Cliente getModel()
    {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb)
    {
        this.setModel((Cliente) cmb.getSelectedItem());
    }

    private void setModel(Cliente model) 
    {
        this.getGestor().setModel(model);
    }

    public GestorCliente getGestor() 
    {
        return gestor;
    }

    public void setGestor(GestorCliente gestor) 
    {
        this.gestor = gestor;
    }

    public FrmCliente getForm()
    {
        return form;
    }

    public void setForm(FrmCliente form) 
    {
        this.form = form;
    }
  
     public void initializeTabla(JTable tbl) 
     {
        String[] titulo={"","Nombre"};
        String[] ancho ={"5","570"};
        this.newModelTable(tbl,titulo,ancho);  
     } 
    
    
    @Override
    public void newModel()
    {
        this.gestor.newModel();
        this.setModoNuevo();
    } 

    @Override
    public void cancelarView() 
    {
        
    }

    @Override
    public void deleteView() 
    {
        
         this.getGestor().eliminar();
         this.getForm().viewEliminar();
    }
    
    @Override
    public int setModel() 
    { 
        if (this.isDatosValidos()) 
        {
            this.getGestor().setNombreMarca(this.getForm().getTxtNombreCliente().getText());     
            //this.getGestor().setTipoProyecto((TipoProyecto) this.getForm().getCmbTipoProyecto().getSelectedItem());
            //this.getGestor().setDetalle(this.getForm().getTbl());
            return 0;
        }
        else 
        {
            return 1;
        } 
    }
    
    @Override
    public void saveView() 
    {
        int err;
        err= this.setModel();
        if (err ==0)
        { 
           this.getGestor().saveModel(this.getOpcABM());
           this.actualizarView();
        }
    }
    
    @Override
    public boolean isDatosValidos()
    {
        if (this.isEmpty(this.getForm().getTxtNombreCliente())) 
           { 
               JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
               this.getForm().getTxtNombreCliente().grabFocus();
               return false; 
           } 
    
        /*
        if (this.isEmpty(this.getForm().getTbl())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar el item de Proyecto");
            //this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
    
    
         if (this.isEmpty(this.getForm().getCmbTipoProyecto())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la tipo de Proyecto");
            this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
        */
        return true;
    }

    /*
    @Override
    public boolean getModelXCodigo(String codigo) {
        Marca auxModel;
        //auxModel=this.gestor.buscarCodigo(codigo);
        if (auxModel!=null) {
          // this.setModel(auxModel);
           return true;  }
        else {
            return false;
        }
    }
    */

    public void setModelMarca(JComboBox cmb) 
    {
        cmb.setModel(gestor.getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla)
    {
        this.setEscritorio(pantalla);
        this.setForm(new FrmCliente(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
      
    @Override
    public void getView() 
    {
        //this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
        this.getForm().getTxtNombreCliente().setText(this.getGestor().getNombreMarca());
        //this.getForm().getCmbTipoProyecto().setSelectedItem(this.getGestor().getTipoProyecto());
        //this.setItems(this.getForm().getTbl());
    }
    
    @Override
    public void actualizarView()
    {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) 
        {
            //this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
            //this.getGestor().setDetalle(this.getForm().getTbl());
        }
   
    } 

    /*
    public void setModelTipoProyecto(JComboBox cmb) {
        cmb.setModel(gestor.getComboModelMarca());
   }
    */
    
    
    /*
    private void setItems(JTable tbl) {
        this.initializeTabla(tbl);
        DefaultTableModel modeloTabla= (DefaultTableModel) tbl.getModel();
        for (ItemProyecto item : this.getGestor().getDetalle()) {
             Object[] fila = {item, item.getDenominacion()}; 
             modeloTabla.addRow(fila);
        }
    }
    
    public void addItem() {
        if (this.isItemValidos()) {
            DefaultTableModel modeloTabla  = (DefaultTableModel) this.getForm().getTbl().getModel(); 
            ItemProyecto item  = new  ItemProyecto(this.getForm().getTxtItemDenominacion().getText());  
          
            Object[] fila = {item, item.getDenominacion() }; 
            modeloTabla.addRow(fila); 
            this.getForm().clearItemView();
        }    
    }
    */

   
    private boolean isItemValidos()
    {
        return true;
    }

    public void removeItem()
    {
       if (this.isItemTablaSelected(this.getForm().getTbl()))
       {
           this.removeItemTabla(this.getForm().getTbl());
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