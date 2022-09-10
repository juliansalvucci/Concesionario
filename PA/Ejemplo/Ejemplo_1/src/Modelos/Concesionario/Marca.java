/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Concesionario;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author julia
 */

@Entity
@Table (name="marca") 

public class Marca implements Comparable
{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
        
    private String nombreMarca;
    
    private int estado;
    
    public String getNombreMarca()
    {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) 
    {
        this.nombreMarca = nombreMarca;
    }

    public int getEstado()
    {
        return estado;
    }

    public void setEstado(int estado) 
    {
        this.estado = estado;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    ///////////////////////////////////////////
    public Marca(){}

    public Marca(String nombreMarca) 
    {
        this.setNombreMarca(nombreMarca);
    }
    
    public void eliminar()
    {
        this.setEstado(1);
    }
    
    @Override
    public String toString () 
    {
        return  this.getNombreMarca();
    }  
    
    @Override
    public int compareTo(Object o) 
    {
        var m = (Marca) o;
        return this.getNombreMarca().compareTo(m.getNombreMarca());
    }    
}
