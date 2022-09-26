/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Concesionario;
import Hibernate.GestorHibernate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author julia
 */

public class GestorMarca extends  GestorHibernate
{
    private Marca  model;
    //private GestorTipoProyecto gestorTipoProyecto = new GestorTipoProyecto();
    
    public Marca  getModel()
    {
        return model;
    }

    public void setModel(Marca  marca)
    {
        this.model = marca;
    }

    /*
    public GestorTipoProyecto getGestorTipoProyecto() {
        return gestorTipoProyecto;
    }

    public void setGestorTipoProyecto(GestorTipoProyecto gestorTipo) {
        this.gestorTipoProyecto = gestorTipo;
    }
    */
    
    // Getter y Setter Objeto principal
    //public String getCodigo() {
      //  return String.valueOf(this.getModel().getCodigo());
    //}
   
    public String getNombreMarca() 
    {
        return this.getModel().getNombreMarca();
    }

    public void setNombreMarca(String nombreMarca) 
    {
        this.getModel().setNombreMarca(nombreMarca);
    }

    public int getEstado()
    {
        return this.getModel().getEstado();
    }

    public void setEstado(int estado) 
    {
        this.getModel().setEstado(estado);
    }
    
    /* 
    public TipoProyecto getTipoProyecto() {
        return this.getModel().getTipoProyecto();
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.getModel().setTipoProyecto(tipoProyecto);
    }
  
    public void setDetalle(JTable tbl) {
        this.setDetalle(UtilJtable.convertToSet(tbl));
    }

    public Set<ItemProyecto> getDetalle() {
        return this.getModel().getItems();
    }

    public void setDetalle(Set<ItemProyecto> detalle) {
        this.getModel().setItems(detalle);
    }
    */
    
   ///////////////////////////////////////////////////////////////
       
    // Altas, bajas y modificaciones 
    public void newModel() 
    {
         this.setModel(new Marca());
    }

    /*
    private void newCodigo() {
        this.getModel().setCodigo(this.getUltimoCodigo()+1);
    }
    */
     
    public void saveModel(int opcABM)
    {
        switch (opcABM)
        {
          case 0:
            this.guardarObjeto();
            break;
          case 1:
            this.actualizarObjeto();
            break;   
          case 2:
            this.guardarObjeto();
            break;
        
        }
    }
    
    public void guardarObjeto()
    {
        //this.newCodigo();
        this.guardarObjeto(this.getModel());
    } 
   
    public void actualizarObjeto() 
    {
        this.actualizarObjeto(this.getModel());
    }
  
    public void eliminar()
    {
        this.getModel().eliminar();
        this.actualizarObjeto();
    }
    
   // busquedas, iteradores y otras 
    public List <Marca> listar()
    {   
        return this.listarClase(Marca.class,"estado",0);
    }
        
    /*
    public List <Proyecto> listar(TipoProyecto tipo){   
          Criteria crit = getSession().createCriteria(Proyecto.class)
                   .add (Restrictions.eq("tipoProyecto",tipo))  
                  .add (Restrictions.eq("estado",0));
        return crit.list();
    }
    */
    
    public DefaultComboBoxModel getComboModel()
    {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Marca auxTipo : this.listar())
        {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }  
    
    /*
    public DefaultComboBoxModel getComboModel(TipoProyecto tipo) {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Proyecto auxTipo : this.listar()) {
 
              
                auxModel.addElement(auxTipo); 
    
        }
         return auxModel;
    }
    
    
     public int getUltimoCodigo(){
          try {
           Proyecto auxModel= (Proyecto) this.listarUltimo(Proyecto.class).get(0);
           return auxModel.getCodigo();
        }
        catch(Exception e){
           return 0;
        }

    }

    public Proyecto buscarCodigo(String codigo) {
        return this.buscarCodigo(Integer.valueOf(codigo));
    }
   
    public Proyecto buscarCodigo(int codigo) {
       Proyecto  auxModel=null;
       try {
          auxModel= (Proyecto) this.listarClaseCodigo(Proyecto.class, codigo).get(0);
          return auxModel;}
       catch(Exception e){
          return auxModel;
       }
    }

    public DefaultComboBoxModel getComboModelTipoProyecto() {
       return this.getGestorTipoProyecto().getComboModel();
    }
    */


}

