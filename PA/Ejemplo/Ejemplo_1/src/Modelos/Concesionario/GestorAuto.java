/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Concesionario;

import Hibernate.GestorHibernate;
import Modelos.GestionProyecto.TipoProyecto;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author julia
 */

public class GestorAuto extends  GestorHibernate
{
    private Auto  model;
    
    public Auto getModel()
    {
        return model;
    }

    public void setModel(Auto  auto) {
        this.model = auto;
    }

    // Getter y Setter Objeto principal
    public String getPrecio() 
    {
        return this.getModel().getPrecio().toString();
    }

    public void setPrecio(Double precio)
    {
        this.getModel().setPrecio(precio);
    }

    public int getEstado() 
    {
        return this.getModel().getEstado();
    }

    public void setEstado(int estado) 
    {
        this.getModel().setEstado(estado);
    }
    
     public Marca getMarca() {
        return this.getModel().getMarca();
    }

    public void setMarca(Marca marca) {
        this.getModel().setMarca(marca);
    }
     
    
   ///////////////////////////////////////////////////////////////
       
    // Altas, bajas y modificaciones 
    public void newModel() 
    {
         this.setModel(new Auto());
    }
 
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
}