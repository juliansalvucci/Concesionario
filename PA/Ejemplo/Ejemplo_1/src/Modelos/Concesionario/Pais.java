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
@Table (name="pais") 

public class Pais implements Comparable
{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
        
    private String nombrePais;
    
    private int estado;
        
    public String getNombrePais()
    {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) 
    {
        this.nombrePais = nombrePais;
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
    public Pais(){}

    public Pais(String nombrePais) 
    {
        this.setNombrePais(nombrePais);
    }
    
    public void eliminar()
    {
        this.setEstado(1);
    }
    
    @Override
    public String toString () 
    {
        return  this.getNombrePais();
    }  
    
    @Override
    public int compareTo(Object o) 
    {
        var m = (Pais) o;
        return this.getNombrePais().compareTo(m.getNombrePais());
    }    
}

